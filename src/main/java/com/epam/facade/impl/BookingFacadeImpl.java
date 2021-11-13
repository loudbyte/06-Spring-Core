package com.epam.facade.impl;

import com.epam.exception.BusinessExcetion;
import com.epam.exception.NotFoundException;
import com.epam.facade.BookingFacade;
import com.epam.model.Event;
import com.epam.model.Ticket;
import com.epam.model.Ticket.Category;
import com.epam.model.User;
import com.epam.service.EventService;
import com.epam.service.TicketService;
import com.epam.service.UserService;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class BookingFacadeImpl implements BookingFacade {

  private final static Logger LOGGER = Logger.getLogger(BookingFacadeImpl.class.getName());

  private final EventService eventService;
  private final TicketService ticketService;
  private final UserService userService;

  public BookingFacadeImpl(EventService eventService, TicketService ticketService,
      UserService userService) {
    this.eventService = eventService;
    this.ticketService = ticketService;
    this.userService = userService;
  }

  @Override
  public Event getEventById(long eventId) {
    return eventService.findById(eventId);
  }

  @Override
  public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
    return eventService.getEventsByTitle(title, pageSize, pageNum);
  }

  @Override
  public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
    return eventService.getEventsForDay(day, pageSize, pageNum);
  }

  @Override
  public Event createEvent(Event event) {
    Event created = null;
    try {
      created = eventService.create(event);
    } catch (BusinessExcetion e) {
      e.printStackTrace();
    }
    return created;
  }

  @Override
  public Event updateEvent(Event event) {
    try {
      return eventService.update(event);
    } catch (NotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean deleteEvent(long eventId) {
    try {
      return eventService.deleteById(eventId);
    } catch (NotFoundException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public User getUserById(long userId) {
    return userService.findById(userId);
  }

  @Override
  public User getUserByEmail(String email) {
    try {
      return userService.getByEmail(email);
    } catch (NotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<User> getUsersByName(String name, int pageSize, int pageNum) {
    return userService.getByName(name, pageSize, pageNum);
  }

  @Override
  public User createUser(User user) {
    try {
      return userService.create(user);
    } catch (BusinessExcetion e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public User updateUser(User user) {
    try {
      return userService.update(user);
    } catch (NotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean deleteUser(long userId) {
    try {
      return userService.deleteById(userId);
    } catch (NotFoundException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public Ticket bookTicket(long userId, long eventId, int place, Category category) {
    return null;
  }

  @Override
  public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
    return null;
  }

  @Override
  public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
    return null;
  }

  @Override
  public boolean cancelTicket(long ticketId) {
    return false;
  }
}
