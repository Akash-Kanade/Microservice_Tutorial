package com.ak.userservice.controller;

import com.ak.userservice.entity.User;
import com.ak.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User u = service.saveUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }
    //single user get
    @GetMapping("/{id}")
   public ResponseEntity<User> getUser(@PathVariable String id)
   {
    User u = service.getUser(id);
    return ResponseEntity.status(HttpStatus.OK).body(u);
   }

    //all user get
   @GetMapping
    public ResponseEntity<List<User>> getAllUser()
   {
       List<User> all = service.getAll();
       return ResponseEntity.status(HttpStatus.OK).body(all);
   }

}
