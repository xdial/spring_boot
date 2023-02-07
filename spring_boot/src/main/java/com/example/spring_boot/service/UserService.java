package com.example.spring_boot.service;

import com.example.spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void createUser(User user);

    User getUser(Long id);

    User updateUser(User user, Long id);

    void deleteUser(Long id);
}