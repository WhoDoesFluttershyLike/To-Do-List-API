package com.example.ToDoListAPI.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateTaskDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Boolean isCompleted;
    private Integer priority;
    private String username;
    private Long categoryId;
}
