package com.spring_crud.service;

import com.spring_crud.entity.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleByName(String name);

    HashSet<Role> getRolesByNames(String[] names);
}
