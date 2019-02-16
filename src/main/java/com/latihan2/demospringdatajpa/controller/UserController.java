package com.latihan2.demospringdatajpa.controller;

import com.latihan2.demospringdatajpa.entity.User;
import com.latihan2.demospringdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("users")
    public User saveData(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("users")
    @ResponseBody
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("users/{userId}")
    public User findById(@PathVariable("userId") Long userId){
        return userRepository.findOne(userId);
    }

    @PutMapping("users/{userId}")
    public User UpdateById(@PathVariable("userId")Long userId, @RequestBody User userObject){
        User user = userRepository.findOne(userId);
        user.setName(userObject.getName());
        user.setCountry(userObject.getCountry());
        return userRepository.findOne(userId);
    }

    @DeleteMapping("users/{userId}")
    public List<User> deleteById (@PathVariable("userId")Long userId){
        userRepository.delete(userId);
        return userRepository.findAll();
    }
}
