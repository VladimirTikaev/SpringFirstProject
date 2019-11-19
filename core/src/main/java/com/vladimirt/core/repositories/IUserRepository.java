package com.vladimirt.core.repositories;

import com.vladimirt.core.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> { //Передаем класс модель и тип id. Наследуемся от этого класса
    // т.к. внутри есть все базовые CURD методы

    User getById(Long id);
}
