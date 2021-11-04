package com.Email.Services;

import com.Email.dao.ContactDAO;
import com.Email.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public class ContactService implements Service<ContactDAO> {

    @Autowired
    private UserDAO userDao;


    @Override
    public List<ContactDAO> findAll() {
        return null;
    }

    @Override
    public Optional<ContactDAO> findById(int theId) {
        return Optional.empty();
    }

    @Override
    public void save(ContactDAO theEntity) {
    }

    @Override
    public void saveWithId(ContactDAO theEntity, int theId) {
    }

    @Override
    public void delete(int theId) {
    }
}
