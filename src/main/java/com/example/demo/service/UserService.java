package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUser(int id) {
        return userRepository.getUserById(id);
    }

    public User updateUser(int id, User user) {
        return userRepository.updateUser(id, user);
    }

    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

}
