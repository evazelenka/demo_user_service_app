package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/all")
//    public List<User> findAll(){
//        return userService.findAll();
//    }

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("users", userService.findAll());
        return "user-list.html";
    }

    @PostMapping()
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/get/{id}")
    public User getTaskById(@PathVariable int id){
        return userService.getUser(id);
    }

    @GetMapping("/update/{id}")
    public User updateTask(@PathVariable int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @GetMapping("/delete/{id}")
    public void deleteTask(@PathVariable int id){
        userService.deleteUser(id);
    }
}
