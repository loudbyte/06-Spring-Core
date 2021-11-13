package com.epam.service;

import java.util.List;

public interface BaseService<T> {

  T findById(long id);

  List<T> findAll();

  T create(T entity);

  T update(T entity);

  boolean deleteById(long id);

}
