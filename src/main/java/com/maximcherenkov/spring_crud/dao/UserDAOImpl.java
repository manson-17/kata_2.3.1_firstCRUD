package com.maximcherenkov.spring_crud.dao;

import com.maximcherenkov.spring_crud.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
       return entityManager.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public User show(int id) {
       return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
       entityManager.merge(user);

    }

    @Override
    public void delete(int id) {
        entityManager.remove(show(id));
    }


}
