package com.luana.springboottodoapplication.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.luana.springboottodoapplication.models.TodoItem;
import com.luana.springboottodoapplication.repositories.TodoItemRepository;


@Controller
public class TodoItemController {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") long id, @Valid TodoItem todoItem, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            todoItem.setId(id);
            return "update-todo-item";
        }

        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "add-todo-item";
        }

        todoItemRepository.save(todoItem);
        return "redirect:/";
    }
}
