package com.grupo01.spring.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "pasarelapago", url= "http://localhost:9999")
public interface FeignClientPasarela {
	
	@GetMapping("/pasarelapago/{ticket_id}")
    public String pago(@PathVariable int ticket_id);

}
