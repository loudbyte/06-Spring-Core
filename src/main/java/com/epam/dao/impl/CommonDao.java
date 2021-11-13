package com.epam.dao.impl;

import com.epam.dao.db.InMemoryDatabase;

public abstract class CommonDao {

  protected static final InMemoryDatabase database = new InMemoryDatabase();

}
