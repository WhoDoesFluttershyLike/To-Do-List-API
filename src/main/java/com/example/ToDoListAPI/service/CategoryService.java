package com.example.ToDoListAPI.service;

import com.example.ToDoListAPI.entity.Category;
import com.example.ToDoListAPI.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;


    public Category save(Category category){
        return categoryRepo.save(category);
    }

    public void remove(Long id){
        categoryRepo.delete(findCategoryById(id));
    }

    public Category findCategoryById(Long id){
        List<Category> listOfCategory = categoryRepo.findAll();
        Category category = new Category();
        for (int i=0; i<listOfCategory.size(); i++){
            if (Objects.equals(listOfCategory.get(i).getId(), id)){
                category = listOfCategory.get(i);
                break;
            }
        }
        return category;
    }
}
