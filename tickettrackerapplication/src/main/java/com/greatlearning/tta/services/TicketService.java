package com.greatlearning.tta.services;

import java.util.List;
import com.greatlearning.tta.entity.Ticket;

public interface TicketService {

	Ticket insertTicket(Ticket ticket);

	void deleteTicketById(int id);

	List<Ticket> getAllTickets();

	Ticket getTicketById(int id);

	Ticket updateTicket(Ticket e);

	List<Ticket> searchTickets(String keyword);

}
