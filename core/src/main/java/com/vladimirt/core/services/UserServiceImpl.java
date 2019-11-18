package com.vladimirt.core.services;

import com.vladimirt.core.model.User;
import com.vladimirt.core.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//Поидее здесь пилиться логика
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    // При запуске приложения в наш серивис через конструктор передастся репозиторий. Это сделает спринг сам
    private final IUserRepository userRepository;

    @Override
    public User getUser(Long id) {

        return userRepository.findById(id).get(); //Здесь создается репозиторий и там за счет того, что он унаследован
        // от касса CRUD у нас есть куча полезных реализованных методов. Пишем .get чтобы вернуло User.
        //Странно тольк то, что у нас нет реализации этого интерфейса
    }
}
