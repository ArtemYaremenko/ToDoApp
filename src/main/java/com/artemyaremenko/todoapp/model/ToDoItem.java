package com.artemyaremenko.todoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class ToDoItem {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    public ToDoItem() {
    }

    public ToDoItem(String title) {
        this.title = title;
    }
}
