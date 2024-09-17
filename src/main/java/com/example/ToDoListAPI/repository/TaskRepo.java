package com.example.ToDoListAPI.repository;

import com.example.ToDoListAPI.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
}
