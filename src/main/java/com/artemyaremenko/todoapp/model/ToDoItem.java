package com.artemyaremenko.todoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ToDoItem {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    public ToDoItem() {
    }

}
