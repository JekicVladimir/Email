package com.Email.Services;

import java.util.List;
import java.util.Optional;

public interface Service<T> {

    public List<T> findAll();

    public List<T> findAllWithId(int theId);

    public Optional<T> findById(int theId);

    public void save(T theEntity);

    public void saveWithId(T theEntity,int theId);

    public void delete(int theId);

}