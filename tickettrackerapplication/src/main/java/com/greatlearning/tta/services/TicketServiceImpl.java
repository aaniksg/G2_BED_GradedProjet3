package com.greatlearning.tta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.repository.TicketRepo;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketRepo ticketRepo;

	@Override
	public Ticket insertTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	@Override
	public void deleteTicketById(int id) {
		ticketRepo.deleteById(id);

	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepo.findAll();
	}

	@Override
	public Ticket getTicketById(int id) {
		return ticketRepo.findById(id).get();
	}

	@Override
	public Ticket updateTicket(Ticket e) {
		return ticketRepo.save(e);
	}

	@Override
	public List<Ticket> searchTickets(String keyword) {
		return ticketRepo.searchTickets(keyword);
	}

}
