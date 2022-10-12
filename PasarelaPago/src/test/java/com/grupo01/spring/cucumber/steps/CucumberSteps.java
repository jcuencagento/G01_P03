package com.grupo01.spring.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.grupo01.spring.controller.PasarelaPagoController;
import com.grupo01.spring.cucumber.config.ApplicationConfig;
import com.grupo01.spring.model.PaymentStatus;
import com.grupo01.spring.request.PaymentRequest;

import io.cucumber.spring.CucumberContextConfiguration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CucumberContextConfiguration
@ContextConfiguration (classes= ApplicationConfig.class)
public class CucumberSteps {

	@Autowired
	//@MockBean
	private PasarelaPagoController controller;
	
	//@Autowired
	//MockMvc mvc;
	
	//@MockBean
	PaymentRequest request;
	
	/*@Given("{int} tries to pay a ticket")
	public void makePayment(int ticket_id) {
		
		assertThat(ticket_id).isNotNull();
		assertThat(ticket_id).isNotNegative();
		log.info("======Id ticket no null ni negativo " + ticket_id);
	}*/

	@Then("Payment from {int} is made successfully")
	public void payment_is_made_successfully(int ticket_id) {
		String result= controller.pago(ticket_id);
		assertThat(result.contains("200"));
		log.info("=============Codigo 200==============");
	}
	@Then("Payment from {int} returns success message")
	public void payment_returns_success_message(int ticket_id) {
		String result= controller.pago(ticket_id);
		assertThat(result.contains("Pago aceptado!"));
		log.info("mensaje: "+result);
	}

	
//SCENARIO 2: forzamos error de transaccion
	
	/*@Given("{int} tries to pay a ticket with error")
	public void makePaymentErrorTransaction(int ticket_id) {
		
		assertThat(ticket_id).isNotNull();
		assertThat(ticket_id).isNotNegative();
		log.info("======Id ticket no null ni negativo " + ticket_id);
	}*/
	
	
	@Then("Payment made from {int} is not made")
	public void payment_is_not_made(int ticket_id) {

		PasarelaPagoController pc= new PasarelaPagoController();
		String result= pc.pago(ticket_id);
		assertThat(result.contains("400.001"));
		log.info("=============Codigo 400.001==============");
	   
	}
	@Then("Payment made from {int} returns transaction error message")
	public void payment_returns_transaction_error_message(int ticket_id) {
		String result= controller.pago(ticket_id);
		assertThat(result.contains("Error en la transaccion"));
		log.info("mensaje error: "+result);
	}	
	
//SCENARIO 3
	
	
	/*@Given("{int} tries to pay a ticket with no funds")
	public void makePaymentErrorFunds(int ticket_id) {
		
		assertThat(ticket_id).isNotNull();
		assertThat(ticket_id).isNotNegative();
		log.info("======Id ticket no null ni negativo " + ticket_id);
	}*/
	
	@Then("Payment made from {int} returns an error")
	public void payment_returns_error_funds(int ticket_id) {

		String result= controller.pago(ticket_id);
		assertThat(result.contains("116.001"));
		log.info("=============Codigo 116.001==============");
	   
	}
	
	
	@Then("Payment made from {int} returns lack of funds error message")
	public void payment_returns_lack_of_funds_error_message(int ticket_id) {
		String result= controller.pago(ticket_id);
		assertThat(result.contains("Usted no tiene un euro"));
		log.info("mensaje fondos: "+result);
	}
	
}



/*
 * //when (controller.pago(ticket_id)).thenReturn("ERROR_TRANSACCION");
		PaymentStatus status = request.getCodigo(850).ERROR_TRANSACCION;
		String result= controller.pago(ticket_id);
		assertThat(result.contains("400.001"));
		//assertThat(status.toString().contains("400.001"));
		 */
