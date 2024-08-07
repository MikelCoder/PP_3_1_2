package com.mike.spring.springboot.pp_3_1_2.controller;


import com.mike.spring.springboot.pp_3_1_2.service.UserServiceImpl;
import com.mike.spring.springboot.pp_3_1_2.model.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {


    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        userService.getUserById(id).ifPresent(user -> model.addAttribute("user", user));
        return "detail";
    }

    @PostMapping("/user")
    public String saveUser(@RequestParam String name, @RequestParam String email) {
        User user = new User(name, email);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/user/update")
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String email) {
        User user = new User(name, email);
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/user/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}