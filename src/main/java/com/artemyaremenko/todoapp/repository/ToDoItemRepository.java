package com.artemyaremenko.todoapp.repository;

import com.artemyaremenko.todoapp.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
}
