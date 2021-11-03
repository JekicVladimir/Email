package com.Email.Services;

import java.util.ArrayList;

import com.Email.dto.UserDTO;
import com.Email.dao.UserDAO;
import com.Email.entity.MyUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public MyUser save(MyUser user) {
//        MyUser newUser = new MyUser();
//        newUser.setUsername(user.getUsername());
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
//        newUser.setFirstName("Vladimir");
//        newUser.setLastName("Jekic");
        return userDao.save(user);
    }

    public MyUser update(MyUser user) {
        MyUser user1 = userDao.findByUsername(user.getUsername());
        user1.setLastName(user.getLastName());
        user1.setFirstName(user.getFirstName());
        //dodaj password i uzmi user name iz tokena da bi mogao i nje ga da menja (getUsernameFromToken)
        return userDao.save(user1);
    }

    public MyUser getUser(int id) {
        return userDao.getById(id);
    }
}