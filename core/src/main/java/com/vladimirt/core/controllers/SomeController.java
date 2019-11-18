package com.vladimirt.core.controllers;

import com.vladimirt.core.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.vladimirt.core.model.User;

@RestController
@RequiredArgsConstructor
public class SomeController {

    private final IUserService userService;

    @GetMapping("/users/{id}")
    public User sayHello(@PathVariable Long id){
        return userService.getUser(id) ;
    }
}
