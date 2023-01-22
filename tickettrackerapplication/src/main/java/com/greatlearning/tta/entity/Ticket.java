package com.greatlearning.tta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "ticket_title", nullable = false)
	private String ticketTitle;
	@Column(name = "ticket_description")
	private String ticketDescription;
	@Column(name = "ticket_date")
	private String ticketDate;
	@Column(name = "ticket_content")
	private String ticketContent;

	public Ticket() {
	}

	public Ticket(int id, String ticketTitle, String ticketDescription, String ticketDate, String ticketContent) {
		super();
		this.id = id;
		this.ticketTitle = ticketTitle;
		this.ticketDescription = ticketDescription;
		this.ticketDate = ticketDate;
		this.ticketContent = ticketContent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}

	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public String getTicketDate() { // Date
		return ticketDate;
	}

	public void setTicketDate(String ticketDate) { // Date
		this.ticketDate = ticketDate;
	}

	public String getTicketContent() {
		return ticketContent;
	}

	public void setTicketContent(String ticketContent) {
		this.ticketContent = ticketContent;
	}
}
