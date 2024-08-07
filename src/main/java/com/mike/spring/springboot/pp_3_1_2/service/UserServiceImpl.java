package com.mike.spring.springboot.pp_3_1_2.service;

import com.mike.spring.springboot.pp_3_1_2.model.User;

import  com.mike.spring.springboot.pp_3_1_2.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Получение всех пользователей
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Получение пользователя по id
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Сохранение нового пользователя
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Обновление пользователя
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Удаление пользователя по id
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
