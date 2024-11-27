package com.example.ToDoListAPI.controller;

import com.example.ToDoListAPI.Dto.TaskDto;
import com.example.ToDoListAPI.Dto.UpdateTaskDto;
import com.example.ToDoListAPI.entity.Category;
import com.example.ToDoListAPI.entity.Task;
import com.example.ToDoListAPI.entity.User;
import com.example.ToDoListAPI.repository.UserRepo;
import com.example.ToDoListAPI.service.CategoryService;
import com.example.ToDoListAPI.service.TaskService;
import com.example.ToDoListAPI.service.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/main")
public class RestController {
    @Autowired
    private final UserRepo userRepo;
    private final CategoryService categoryService;
    private final TaskService taskService;
    private final UserDetailsImp userDetailsImp;

    public RestController(UserRepo userRepo, CategoryService categoryService, TaskService taskService, UserDetailsImp userDetailsImp) {
        this.userRepo = userRepo;
        this.categoryService = categoryService;
        this.taskService = taskService;
        this.userDetailsImp = userDetailsImp;
    }


    @PostMapping("/create-category")
    public Category createCategory(@RequestParam String name){
        Category category = new Category();
        category.setName(name);
        categoryService.save(category);
        return category;
    }

    @DeleteMapping("/delete-category")
    public void deleteCategory(@RequestParam Long id){
        categoryService.remove(id);
    }

    @PostMapping("create-task")
    public Task createTask(@RequestBody TaskDto taskDto){
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setPriority(taskDto.getPriority());
        task.getCategories().add(categoryService.findCategoryById(taskDto.getCategoryId()));
        task.setUser((User) userDetailsImp.loadUserByUsername(taskDto.getUsername()));
        task.setCreatedAt(LocalDateTime.now());
        taskService.save(task);
        return task;
    }

    @GetMapping("read-task")
    public Task readTask(@RequestParam Long id){
        return taskService.getById(id);
    }

    @PutMapping("update-task")
    public Task updateTask(@RequestBody UpdateTaskDto updateTaskDto){
        Task task = taskService.getById(updateTaskDto.getId());
        task.setTitle(updateTaskDto.getTitle());
        task.setDescription(updateTaskDto.getDescription());
        task.setDueDate(updateTaskDto.getDueDate());
        task.setPriority(updateTaskDto.getPriority());
        task.setIsCompleted(updateTaskDto.getIsCompleted());
        task.setUpdatedAt(LocalDateTime.now());
        task.getCategories().add(categoryService.findCategoryById(updateTaskDto.getCategoryId()));
        task.setUser((User) userDetailsImp.loadUserByUsername(updateTaskDto.getUsername()));
        taskService.save(task);
        return task;


    }

    @DeleteMapping("delete-task")
    public void deleteTask(@RequestParam Long id){
        taskService.delete(id);
    }


}
