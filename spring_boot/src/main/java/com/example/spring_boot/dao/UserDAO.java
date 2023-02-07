package com.example.spring_boot.dao;

import com.example.spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO /*extends JpaRepository<User, Long> */{
    List<User> getAllUsers();

    void createUser(User user);

    User getUser(Long id);

    User updateUser(User user, Long id);

    void deleteUser(Long id);

}