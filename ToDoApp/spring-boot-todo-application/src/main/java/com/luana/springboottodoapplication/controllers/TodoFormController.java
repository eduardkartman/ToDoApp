package com.luana.springboottodoapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.luana.springboottodoapplication.models.TodoItem;
import com.luana.springboottodoapplication.repositories.TodoItemRepository;

@Controller
public class TodoFormController {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo item nor found"));
        model.addAttribute("todo", todoItem);
        return "update-todo-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long id, Model model) {
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo item nor found"));
        todoItemRepository.delete(todoItem);
        return "redirect:/";
    }

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem) {
        return "add-todo-item";
    }

    @GetMapping("/done/{id}")
    public String markAsComplete(@PathVariable("id") long id, Model model) {
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo item nor found"));
        todoItem.setComplete(true);
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }
}
