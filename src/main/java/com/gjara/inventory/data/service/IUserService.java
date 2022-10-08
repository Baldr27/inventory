package com.gjara.inventory.data.service;

import java.util.List;

import com.gjara.inventory.data.entities.User;

public interface IUserService {
    
    List<User> getAllUsers();
    User saveUser(User user);
    User updateUser(User user);
    User getUserById(Long id);
    void deleteUser(Long id);
}
