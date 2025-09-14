package com.artemyaremenko.todoapp.controllers;

import com.artemyaremenko.todoapp.model.ToDoItem;
import com.artemyaremenko.todoapp.repository.ToDoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ToDoController {

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

    @PostMapping("/search")
    public String searchToDo(@RequestParam("searchTerm") String searchTerm, Model model) {
        List<ToDoItem> searchResults = toDoItemRepository.findAll().stream()
                        .filter(toDoItem -> toDoItem.getTitle().toLowerCase().contains(searchTerm.toLowerCase()))
                        .toList();
        model.addAttribute("allToDos", searchResults);
        model.addAttribute("newToDo", new ToDoItem());
        model.addAttribute("searchTerm", searchTerm);
        return "index";
    }
}
