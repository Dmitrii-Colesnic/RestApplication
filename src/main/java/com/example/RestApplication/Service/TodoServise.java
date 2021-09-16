package com.example.RestApplication.Service;

import com.example.RestApplication.Entity.TodoEntity;
import com.example.RestApplication.Entity.UserEntity;
import com.example.RestApplication.Model.Todo;
import com.example.RestApplication.Repository.TodoRepo;
import com.example.RestApplication.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServise {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);

        return Todo.model(todoRepo.save(todo));
    }

    public Todo completeTodo(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.isCompleted());

        return Todo.model(todoRepo.save(todo));
    }
}
