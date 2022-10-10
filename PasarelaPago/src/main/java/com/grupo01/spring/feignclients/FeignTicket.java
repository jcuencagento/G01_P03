package com.grupo01.spring.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.grupo01.spring.dto.TicketDTO;

@FeignClient(name = "ticket", url = "http://localhost:8888")
public interface FeignTicket {

	@GetMapping("/{ticket_id}/pay")
	public TicketDTO payTicket(@PathVariable int ticket_id);

}
