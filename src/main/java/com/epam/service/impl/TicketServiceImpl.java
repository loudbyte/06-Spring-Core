package com.epam.service.impl;

import com.epam.dao.TicketDao;
import com.epam.exception.BusinessExcetion;
import com.epam.exception.NotFoundException;
import com.epam.model.Ticket;
import com.epam.service.TicketService;
import java.util.List;

public class TicketServiceImpl implements TicketService {

  private final TicketDao ticketDao;

  public TicketServiceImpl(TicketDao ticketDao) {
    this.ticketDao = ticketDao;
  }

  @Override
  public Ticket findById(long id) {
    return ticketDao.findById(id);
  }

  @Override
  public List<Ticket> findAll() {
    return ticketDao.findAll();
  }

  @Override
  public Ticket create(Ticket entity) throws BusinessExcetion {
    return ticketDao.create(entity);
  }

  @Override
  public Ticket update(Ticket entity) throws NotFoundException {
    return ticketDao.update(entity);
  }

  @Override
  public boolean deleteById(long id) throws NotFoundException {
    return ticketDao.delete(ticketDao.findById(id));
  }
}
