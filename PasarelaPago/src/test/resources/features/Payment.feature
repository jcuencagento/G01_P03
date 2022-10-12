
Feature: Making a payment


Background: User A tries to pay a ticket


#  @Test_Success
  Scenario: User A tries to pay a ticket successfully
   #Given 3 tries to pay a ticket
    Then Payment from 3 is made successfully
    And Payment from 3 returns success message

#Error en el que falla la transaccion bancaria
 # @Test_error
   Scenario: User tries to pay a ticket with transaction error message
    #Given 4 tries to pay a ticket with error
    Then Payment made from 4 is not made
    And Payment made from 4 returns transaction error message

#Error en el que no hay dinero 
#@Test_error
 Scenario: User tries to pay a ticket with funds error message
  	#Given 5 tries to pay a ticket with no funds
    Then Payment made from 5 returns an error
    And Payment made from 5 returns lack of funds error message
    
    #Ejemplos de posibles resultados
    #Examples: 
    #  | ticket_id   | random 	| status 					|
    #  |  3					 |   234   	| OK			 				|
    #  |	6				   |	 803	  | ERROR    				|
    #  |	9				   |	 955	  | ERROR_SALDO     |
