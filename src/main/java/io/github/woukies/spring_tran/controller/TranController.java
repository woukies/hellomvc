package io.github.woukies.spring_tran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.woukies.spring_tran.dao.TicketDao;
import io.github.woukies.spring_tran.dto.TicketDto;

@Controller
@RequestMapping("/spring_tran")
public class TranController {
	private TicketDao dao;

	@Autowired
	public void setDao(TicketDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "/spring_tran/buy_ticket";
	}

	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDto dto, Model model) {
		dao.buyTicket(dto);
		model.addAttribute("ticketInfo", dto);
		
		return "/spring_tran/buy_ticket_end";
	}
}
