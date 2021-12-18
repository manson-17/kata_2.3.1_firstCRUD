package com.maximcherenkov.spring_crud.dao;

import com.maximcherenkov.spring_crud.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    User show(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}
