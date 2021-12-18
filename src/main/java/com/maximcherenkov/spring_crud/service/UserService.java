package com.maximcherenkov.spring_crud.service;

import com.maximcherenkov.spring_crud.entity.User;

import java.util.List;

public interface UserService {

        List<User> getAllUsers();
        
        User show(int id);

        void save(User user);

        void update(int id, User user);

        void delete(int id);
}

