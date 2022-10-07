package com.grupo01.spring.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.grupo01.spring.response.EventoDTO;


//Se añade este nombre : spring.application.name=catalog
//Indico que voy a contactar con esa ruta
@FeignClient(name = "catalogevent", url= "http://localhost:6666")
public interface CatalogFeignClientEvent {
	
    @GetMapping("/evento/{event_id}")
    public EventoDTO getEvent (@PathVariable int event_id);
    
    

}

