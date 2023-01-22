package com.greatlearning.tta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.services.TicketService;

@Controller
public class TicketController {
	@Autowired
	private TicketService ticketService;

	@GetMapping("/tickets")
	public String listTickets(Model model, String keyword) {
		List<Ticket> tickets = ticketService.getAllTickets();

		if (keyword != null) {
			model.addAttribute("tickets", ticketService.searchTickets(keyword));
		} else {
			model.addAttribute("tickets", tickets);
		}
		return "tickets";
	}

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable("id") int id) {
		ticketService.deleteTicketById(id);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/new")
	public String createTicketForm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";
	}

	@PostMapping("/tickets")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.insertTicket(ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable("id") int id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "edit_ticket";
	}

	@PostMapping("/tickets/{id}")
	public String updateTicket(@PathVariable("id") int id, @ModelAttribute("ticket") Ticket ticket) {
		Ticket existingTicket = ticketService.getTicketById(id);
		existingTicket.setTicketTitle(ticket.getTicketTitle());
		existingTicket.setTicketDescription(ticket.getTicketDescription());
		existingTicket.setTicketDate(ticket.getTicketDate());
		existingTicket.setTicketContent(ticket.getTicketContent());
		ticketService.insertTicket(existingTicket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/view/{id}")
	public String viewTicketById(@PathVariable("id") int id, Model model) {
		Ticket tickets = ticketService.getTicketById(id);
		model.addAttribute("tickets", tickets);
		return "view_ticket";
	}

}
