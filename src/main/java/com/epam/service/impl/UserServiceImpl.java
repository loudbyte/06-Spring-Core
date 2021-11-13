package com.epam.service.impl;

import com.epam.dao.UserDao;
import com.epam.exception.BusinessExcetion;
import com.epam.exception.NotFoundException;
import com.epam.model.User;
import com.epam.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public User findById(long id) {
    return userDao.findById(id);
  }

  @Override
  public List<User> findAll() {
    return userDao.findAll();
  }

  @Override
  public User create(User entity) throws BusinessExcetion {
    userDao.create(entity);
  }

  @Override
  public User update(User entity) throws NotFoundException {
    userDao.update(entity);
  }

  @Override
  public boolean deleteById(long id) throws NotFoundException {
    userDao.delete(userDao.findById(id));
  }
}
