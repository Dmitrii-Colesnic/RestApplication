package com.example.RestApplication.Controller;

import com.example.RestApplication.Entity.TodoEntity;
import com.example.RestApplication.Service.TodoServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoServise todoServise;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId
    ){
        try{
            return ResponseEntity.ok(todoServise.createTodo(todo, userId));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id){
        try{
            return ResponseEntity.ok(todoServise.completeTodo(id));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }
}
