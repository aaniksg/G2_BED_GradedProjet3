package com.greatlearning.tta.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.tta.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	@Query("SELECT t FROM Ticket t WHERE t.ticketTitle LIKE CONCAT('%',:keyword,'%')")
	List<Ticket> searchTickets(String keyword);

}
