package com.maximcherenkov.spring_crud.dao;

import com.maximcherenkov.spring_crud.entity.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = entityManager.createQuery("from User ", User.class).getResultList();

        return allUsers;
    }

    @Override
    public User show(int id) {
        User user = entityManager.createQuery("from User where id = :userId", User.class)
                .setParameter("userId", id).getSingleResult();

        return user;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User user) {
        User user1 = show(id);
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(show(id));
    }


}
