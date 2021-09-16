package com.example.RestApplication.Controller;

import com.example.RestApplication.Entity.UserEntity;
import com.example.RestApplication.Exceptions.UserAlreadyExistException;
import com.example.RestApplication.Exceptions.UserNotFoundExeption;
import com.example.RestApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("user saved successfully");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundExeption e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }
}
