package com.mike.spring.springboot.pp_3_1_2.service;

import com.mike.spring.springboot.pp_3_1_2.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    // Получение всех пользователей
    List<User> getAllUsers();

    // Получение пользователя по id
    Optional<User> getUserById(Long id);

    // Сохранение нового пользователя
    User saveUser(User user);

    // Обновление пользователя
    User updateUser(User user);

    // Удаление пользователя по id
    void deleteUser(Long id);
}