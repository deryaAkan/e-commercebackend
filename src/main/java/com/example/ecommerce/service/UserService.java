package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
    Optional<User> getUserByEmail(String email);
}
