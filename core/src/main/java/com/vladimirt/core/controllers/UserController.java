package com.vladimirt.core.controllers;

import com.vladimirt.core.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.vladimirt.core.model.User;

@RestController //Указывает что здесь у нас контроллер
@RequiredArgsConstructor// анотация ломбока - создает конструктор для всех final полей
public class UserController {

    private final IUserService userService; // Здесь используем интерфейс и мы не будем привязаны к реалиазции сервиса

    @GetMapping("/users/{id}") // Здесь указываем путь и переменные в таких скобках {}
    public User sayHello(@PathVariable Long id){//Здесь для того чтобы использовать переменную id из браузерной строки
        // нужно указаться @PathVariable
        return userService.getUser(id) ;
    }
}
