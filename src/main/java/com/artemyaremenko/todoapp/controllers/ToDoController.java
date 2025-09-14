package com.artemyaremenko.todoapp.controllers;

import com.artemyaremenko.todoapp.model.ToDoItem;
import com.artemyaremenko.todoapp.repository.ToDoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("newToDo", new ToDoItem());
        return "index";
    }

    @PostMapping("/add")
    public String addToDo(@ModelAttribute ToDoItem newTodoItem) {
        toDoItemRepository.save(newTodoItem);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteToDo(@PathVariable("id") Long id) {
        toDoItemRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteAll() {
        toDoItemRepository.deleteAll();
        return "redirect:/";
    }

    @Override
    public void run(String... args) throws Exception {
        toDoItemRepository.save(new ToDoItem("Item 1"));
        toDoItemRepository.save(new ToDoItem("Item 2"));
    }
}
