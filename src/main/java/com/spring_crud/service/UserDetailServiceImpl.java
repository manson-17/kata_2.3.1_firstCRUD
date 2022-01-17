package com.spring_crud.service;

import com.spring_crud.dao.UserDAO;
import com.spring_crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public UserDetailServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.getUserByName(s);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with name '%s', not found", s));
        }
        return user;
    }
}
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       User user = userDAO.getUserByName(username);
//       if (user == null){
//           throw  new UsernameNotFoundException(String.format("User with name '%s', not found", username));
//       }
//       return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
//            mapRolesToAuthorities(user.getRoles()));
//    }
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
//    }
//
//}
