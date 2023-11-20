package com.luana.springboottodoapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.luana.springboottodoapplication.models.TodoItem;
import com.luana.springboottodoapplication.repositories.TodoItemRepository;

@Component
public class TodoItemDataLoader implements CommandLineRunner {

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        if (todoItemRepository.count() == 0) {
            TodoItem todoItem1 = new TodoItem("Wash the dishes.");
            TodoItem todoItem2 = new TodoItem("Cook.");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }
    }
}
