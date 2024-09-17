package com.example.ToDoListAPI.Dto;

import com.example.ToDoListAPI.entity.Category;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class TaskDto {
    private String title;

    private String description;

    private LocalDate dueDate;
    private Integer priority;

    private String username;

    private Long categoryId;
}
