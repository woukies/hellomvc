package io.github.woukies.spring_tran_apply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.woukies.spring_tran_apply.dao.TicketDao;
import io.github.woukies.spring_tran_apply.dto.TicketDto;

@Controller
@RequestMapping("/spring_tran_apply")
public class TranApplyController {
	private TicketDao dao2;

	@Autowired
	public void setDao2(TicketDao dao2) {
		this.dao2 = dao2;
	}

	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "/spring_tran_apply/buy_ticket";
	}

	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDto dto, Model model) {
		dao2.buyTicket(dto);
		model.addAttribute("ticketInfo", dto);
		
		return "/spring_tran_apply/buy_ticket_end";
	}
}
