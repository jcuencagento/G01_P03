package com.grupo01.spring.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.test.context.ContextConfiguration;
import com.grupo01.spring.cucumber.config.ApplicationConfig;
import com.grupo01.spring.model.PaymentStatus;
import com.grupo01.spring.request.PaymentRequest;
import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CucumberContextConfiguration
@ContextConfiguration(classes = ApplicationConfig.class)
public class CucumberSteps {

	/*
	 * @Given("{int} tries to pay a ticket") public void makePayment(int ticket_id)
	 * {
	 * 
	 * assertThat(ticket_id).isNotNull(); assertThat(ticket_id).isNotNegative();
	 * log.info("======Id ticket no null ni negativo " + ticket_id); }
	 */

	@Then("Payment from {int} is made successfully")
	public void payment_is_made_successfully(int ticket_id) {
		//PaymentStatus result = request.getCodigo(799);
		PaymentStatus result =PaymentRequest.getCodigo(799);
		assertEquals(PaymentStatus.OK, result);
		log.info("=============Codigo 200==============");
	}

	@Then("Payment from {int} returns success message")
	public void payment_returns_success_message(int ticket_id) {
		//PaymentStatus result = request.getCodigo(799);
		PaymentStatus result =PaymentRequest.getCodigo(799);
		assertThat(result.getDescripcion().contains("Pago aceptado!"));
		log.info("mensaje: " + result);
	}

//SCENARIO 2: forzamos error de transaccion
	/*
	 * @Given("{int} tries to pay a ticket with error") public void
	 * makePaymentErrorTransaction(int ticket_id) {
	 * assertThat(ticket_id).isNotNull(); assertThat(ticket_id).isNotNegative();
	 * log.info("======Id ticket no null ni negativo " + ticket_id); }
	 */

	@Then("Payment made from {int} is not made")
	public void payment_is_not_made(int ticket_id) {
		// PasarelaPagoController pc = new PasarelaPagoController();
		/// PagoDTO result = pc.pago(ticket_id, 0, null);
		PaymentStatus result =PaymentRequest.getCodigo(899);
		assertEquals(PaymentStatus.ERROR_BANK, result);
		log.info("=============Codigo 400.100==============");

	}

	@Then("Payment made from {int} returns transaction error message bank code invalid")
	public void payment_returns_transaction_error_message(int ticket_id) {
		// PagoDTO result = controller.pago(ticket_id, 0, null);
		PaymentStatus result =PaymentRequest.getCodigo(899);
		assertThat(result.getDescripcion().contains("Bank code invalid"));
		log.info("mensaje error: " + result);
	}

//SCENARIO 3
	/*
	 * @Given("{int} tries to pay a ticket with no funds") public void
	 * makePaymentErrorFunds(int ticket_id) { assertThat(ticket_id).isNotNull();
	 * assertThat(ticket_id).isNotNegative();
	 * log.info("======Id ticket no null ni negativo " + ticket_id); }
	 */

	@Then("Payment made from {int} returns an error card declined")
	public void payment_returns_error_funds(int ticket_id) {
		PaymentStatus result =PaymentRequest.getCodigo(959);
		assertEquals(PaymentStatus.ERROR_DECLINED, result);
		log.info("=============Codigo 500.100==============");

	}

	@Then("Payment made from {int} returns lack of funds error message")
	public void payment_returns_lack_of_funds_error_message(int ticket_id) {
		PaymentStatus result =PaymentRequest.getCodigo(959);
		assertThat(result.getDescripcion().contains("Card declined"));
		log.info("mensaje error: " + result);
	}

	// SCENARIO 4
	@Then("Payment made from {int} returns invalid card security code error")
	public void invalid_card_security_code_error(int ticket_id) {
		PaymentStatus result =PaymentRequest.getCodigo(929);
		assertEquals(PaymentStatus.ERROR_CARDSECURITYCODE, result);
		log.info("=============Codigo 400.103==============");

	}

	@Then("Payment made from {int} returns invalid card security code error message")
	public void invalid_card_security_code_error_message(int ticket_id) {
		PaymentStatus result =PaymentRequest.getCodigo(929);
		assertThat(result.getDescripcion().contains("Invalid card security code"));
		log.info("mensaje error: " + result);
	}

	// SCENARIO 5
	@Then("Payment made from {int} returns account blocked error")
	public void account_blocked_error(int ticket_id) {
		PaymentStatus result =PaymentRequest.getCodigo(991);
		assertEquals(PaymentStatus.ERROR_ACCOUNTBLOCKED, result);
		log.info("=============Codigo 500.104==============");

	}

	@Then("Payment made from {int} returns account blocked error message")
	public void account_blocked_error_message(int ticket_id) {
		PaymentStatus result =PaymentRequest.getCodigo(929);
		assertThat(result.getDescripcion().contains("Account blocked"));
		log.info("mensaje error: " + result);
	}
	
	
	// SCENARIO PRUEBA
	@Given("{int} tries to pay a ticket")
	public void tries_to_pay_a_ticket(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("Payment made from {int}")
	public void payment_made_from(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("Payment made from {int} returns message")
	public void payment_made_from_returns_message(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
	}
}
