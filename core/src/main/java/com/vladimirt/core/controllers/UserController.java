package com.vladimirt.core.controllers;

import com.vladimirt.core.dto.RoleDTO;
import com.vladimirt.core.dto.UserDTO;
import com.vladimirt.core.model.Role;
import com.vladimirt.core.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.vladimirt.core.model.User;

import java.util.Set;
import java.util.stream.Collectors;

@RestController //Указывает что здесь у нас контроллер
@RequiredArgsConstructor// анотация ломбока - создает конструктор для всех final полей
public class UserController {

    private final IUserService userService; // Здесь используем интерфейс и мы не будем привязаны к реалиазции сервиса

    @GetMapping("/users/{id}") // Здесь указываем путь и переменные в таких скобках {}
    public UserDTO sayHello(@PathVariable Long id){//Здесь для того чтобы использовать переменную id из браузерной строки
        // нужно указаться @PathVariable
        User user = userService.getUser(id);
        return toDTO(user);
    }

    private RoleDTO toDTO(Role role){
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    private Set<RoleDTO> toDTO(Set<Role> role){

        return role.stream().map(role1 -> toDTO(role1)).collect(Collectors.toSet());
    }


    private UserDTO toDTO(User user){

        Set<RoleDTO> roleDTOS = toDTO(user.getRoles());
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .roles(roleDTOS)
                .build();
    }



}
