package com.mvc.blogs_api.service;

import java.util.Optional;

public interface IManager <T>{
    Iterable<T> findAll();

    T save(T t);

    Optional<T> findById(Long id);

    void remove(Long id);

}
