package com.artemyaremenko.todoapp.controllers;

import com.artemyaremenko.todoapp.model.ToDoItem;
import com.artemyaremenko.todoapp.repository.ToDoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ToDoController implements CommandLineRunner {

    private final ToDoItemRepository toDoItemRepository;

    public ToDoController(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    @GetMapping
    public String index(Model model) {
        List<ToDoItem> allToDos = toDoItemRepository.findAll();
        model.addAttribute("allToDos", allToDos);
        return "index";
    }

    @Override
    public void run(String... args) throws Exception {
        toDoItemRepository.save(new ToDoItem("Item 1"));
        toDoItemRepository.save(new ToDoItem("Item 2"));
    }
}
