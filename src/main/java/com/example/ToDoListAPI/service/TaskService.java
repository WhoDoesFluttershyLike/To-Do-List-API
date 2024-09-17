package com.example.ToDoListAPI.service;

import com.example.ToDoListAPI.entity.Task;
import com.example.ToDoListAPI.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;

    public Task save(Task task){
        return taskRepo.save(task);
    }

    public void delete(Long id){
        taskRepo.deleteById(Math.toIntExact(id));
    }

    public List<Task> getAll(){
        return taskRepo.findAll();
    }

    public Task getById(Long id){
        List<Task> list = taskRepo.findAll();
        Task task = new Task();
        for (Task tasks : list) {
            if (Objects.equals(tasks.getId(), id)) {
                task = tasks;
                break;
            }
        }
        return task;
    }

    public List<Task> getByStatus(boolean b){
        List<Task> list = taskRepo.findAll();
        List<Task> sortedlist = new ArrayList<>();
        for (Task tasks : list) {
            if (tasks.getIsCompleted() == b){
                sortedlist.add(tasks);
            }
        }
        return sortedlist;
    }

    public Task update(Task task){
        task.setIsCompleted(true);
        return task;


    }



}
