package com.luana.springboottodoapplication.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todo_item")
public class TodoItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;


    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private boolean complete;

    public TodoItem() {}

    public TodoItem(String description) {
        this.description = description;
        this.complete = false;
    }

    @Override
    public String toString() {
        return String.format("TodoItem{id='%d', description='%s', complete='%s'}", id, description, complete);
    }

}
