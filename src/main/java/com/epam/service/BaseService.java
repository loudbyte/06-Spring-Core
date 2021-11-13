package com.epam.service;

import com.epam.exception.BusinessExcetion;
import com.epam.exception.NotFoundException;
import java.util.List;

public interface BaseService<T> {

  T findById(long id);

  List<T> findAll();

  T create(T entity) throws BusinessExcetion;

  T update(T entity) throws NotFoundException;

  boolean deleteById(long id) throws NotFoundException;

}
