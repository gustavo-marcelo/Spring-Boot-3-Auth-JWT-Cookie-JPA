package com.example.security.full.security.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.full.security.users.Requests.UsersRequest;
import com.example.security.full.security.users.model.Users;
import com.example.security.full.security.users.service.UsersService;


@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
	@Autowired
    private UsersService usersService;

    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<Users> getUsers() {
        return usersService.getAllUsers();
    }


    @PostMapping
    public Users addUser(@RequestBody UsersRequest user) {
        return usersService.addUser(user);
    }

    
}
