package com.luana.springboottodoapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.luana.springboottodoapplication.models.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {
    
}
