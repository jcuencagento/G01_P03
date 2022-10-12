package com.grupo01.spring.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo01.spring.response.PagoDTO;


@FeignClient(name = "pasarelapago", url= "http://localhost:9999")
public interface FeignClientPasarela {
	
	@PostMapping("/pasarelapago/{ticket_id}")
    public PagoDTO pago(@PathVariable("ticket_id") int ticket_id, @RequestParam int precio_total, @RequestParam String user_mail);

}
