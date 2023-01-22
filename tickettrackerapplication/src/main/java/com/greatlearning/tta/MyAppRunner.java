package com.greatlearning.tta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.repository.TicketRepo;

@Component
public class MyAppRunner implements CommandLineRunner {
	@Autowired
	private TicketRepo ticketRepo;

	@Override
	public void run(String... args) throws Exception {
		Ticket ticket1 = new Ticket();
		ticket1.setTicketTitle("Ticket 1");
		ticket1.setTicketDescription("Ticket Opened");
		ticket1.setTicketDate("2023-01-11");
		ticket1.setTicketContent("Ticket Opened");

		Ticket ticket2 = new Ticket();
		ticket2.setTicketTitle("Ticket 2");
		ticket2.setTicketDescription("Ticket Opened");
		ticket2.setTicketDate("2023-01-11");
		ticket2.setTicketContent("Ticket Opened");

		ticketRepo.save(ticket1);
		ticketRepo.save(ticket2);

	}

}
