package com.Email.Services;

import java.util.ArrayList;

import com.Email.config.JwtTokenUtil;
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

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


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
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }

    public MyUser update(MyUser user, String token) {//proveriti jos i dodati opcije za promenu pasworda
        String jwtToken = token.substring(7);
        String userName =jwtTokenUtil.getUsernameFromToken(jwtToken);
        MyUser user1 = userDao.findByUsername(userName);
        user1.setUsername(user.getUsername());
        user1.setLastName(user.getLastName());
        user1.setFirstName(user.getFirstName());
        return userDao.save(user1);
    }

    public MyUser getUser(int id) {// ovo u zivotu ne treba
        return userDao.getById(id);
    }
}