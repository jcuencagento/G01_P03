package com.grupo01.spring.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo01.spring.response.UserDTO;


//Se añade este nombre : spring.application.name=catalog
//Indico que voy a contactar con esa ruta
@FeignClient(name = "databaseusers", url= "http://localhost:7777")
public interface CatalogFeignClientUser {
	
	//QUE VENGA DEL LOGIN !!!!
    @PostMapping("user/login")
    public UserDTO login (@RequestParam String mail, @RequestParam String pwd);
    
    

}

