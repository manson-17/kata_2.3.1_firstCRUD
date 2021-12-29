package com.spring_crud.dao;

import com.spring_crud.entity.Role;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        return entityManager.createQuery("from Role where name = :roleName", Role.class)
                .setParameter("roleName", name).getSingleResult();
    }

    @Override
    public HashSet<Role> getRolesByNames(String[] names) {
        Set<Role> roleSet = Arrays.stream(names).map(s -> getRoleByName(s)).collect(Collectors.toSet());

        return (HashSet<Role>) roleSet;

    }
}
