package com.example.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.spring_boot.model.User;
import com.example.spring_boot.service.UserService;

import java.util.List;

@Controller
public class CRUDController {
    private final UserService userService;


    public CRUDController(UserService userService) {

        this.userService = userService;
    }

    //ALL USERS
    @GetMapping("/users")
    public String allUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("allUsers", users);
        return "users";
    }

    //NEW USER
    @GetMapping("/addNewUser")
    public String addUser(@ModelAttribute("user") User user) {

        return "addNewUser";
    }

    @PostMapping("/addNewUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    // SHOW USER
    @GetMapping("/{id}")
    public String showById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("showUser", userService.getUser(id));
        return "showById";
    }

    //UPDATE
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        userService.updateUser(user, id);
        return "redirect:/users";

    }


    //DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}