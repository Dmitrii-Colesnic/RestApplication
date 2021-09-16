package com.example.RestApplication.Model;

import com.example.RestApplication.Entity.TodoEntity;
import com.example.RestApplication.Entity.UserEntity;

public class Todo {

    private Long id;
    private String title;
    private boolean completed;

    public static Todo model(TodoEntity todoEntity) {
        Todo model = new Todo();
        model.setId(todoEntity.getId());
        model.setTitle(todoEntity.getTitle());
        model.setCompleted(todoEntity.isCompleted());

        return model;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
