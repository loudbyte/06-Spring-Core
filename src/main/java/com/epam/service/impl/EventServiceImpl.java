package com.epam.service.impl;

import com.epam.dao.EventDao;
import com.epam.exception.BusinessExcetion;
import com.epam.exception.NotFoundException;
import com.epam.model.Event;
import com.epam.service.EventService;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EventServiceImpl implements EventService {

  private final EventDao eventDao;

  public EventServiceImpl(EventDao eventDao) {
    this.eventDao = eventDao;
  }

  @Override
  public Event findById(long id) {
    return eventDao.findById(id);
  }

  @Override
  public List<Event> findAll() {
    return eventDao.findAll();
  }

  @Override
  public Event create(Event entity) throws BusinessExcetion {
    return eventDao.create(entity);
  }

  @Override
  public Event update(Event entity) throws NotFoundException {
    return eventDao.update(entity);
  }

  @Override
  public boolean deleteById(long id) throws NotFoundException {
    eventDao.delete(eventDao.findById(id));
  }

  @Override
  public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
    return eventDao.findAll().stream()
        .filter(event -> Objects.equals(event.getDate(), day))
        .collect(Collectors.toList());
  }

  @Override
  public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
    return eventDao.findAll().stream()
        .filter(event -> Objects.equals(event.getTitle(), title))
        .collect(Collectors.toList());
  }
}
