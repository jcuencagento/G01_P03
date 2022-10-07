package com.grupo01.spring.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.grupo01.spring.response.UserDTO;


//Se añade este nombre : spring.application.name=catalog
//Indico que voy a contactar con esa ruta
@FeignClient(name = "databaseusers", url= "http://localhost:7777")
public interface CatalogFeignClientUser {
	
	//QUE VENGA DEL LOGIN !!!!
    @GetMapping("user/{user_id}")
    public UserDTO getUser (@PathVariable int user_id);
    
    

}

