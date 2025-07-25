package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("users", userService.findAll());
        return "user-list.html";
    }

    @GetMapping("/user-create")
    public String createUser(){
        return "user-create.html";
    }

    @PostMapping("/user-create")
    public String createUser(User user, Model model){
        userService.saveUser(user);
        model.addAttribute("user", user);
        return findAll(model);
    }

    @PostMapping("/user-update/{id}")
    public String updateUser(@PathVariable int id, User user, Model model){
        userService.updateUser(id, user);
        return findAll(model);
    }

    @GetMapping("/user-update/{id}")
    public String updateUser(@PathVariable int id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "user-update.html";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteTask(@PathVariable int id, Model model){
        userService.deleteUser(id);
        return findAll(model);
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUser(id);
    }
}
