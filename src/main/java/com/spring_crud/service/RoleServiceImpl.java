package com.spring_crud.service;

import com.spring_crud.dao.RoleDAO;
import com.spring_crud.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {


    private RoleDAO roleDAO;

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }



    @Override
    public HashSet<Role> getRolesByNames(String[] names) {
        Set<Role> roleSet = new HashSet<>();
        List<Role> allRoles = getAllRoles();
        for(Role role: allRoles) {
            for (String name : names) {
                if (name.equals(role.getName())) {
                    roleSet.add(role);
                }
            }
        }
        return (HashSet<Role>) roleSet;
    }
}
