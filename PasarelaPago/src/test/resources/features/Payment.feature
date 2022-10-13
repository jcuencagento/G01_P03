
Feature: Making a payment

Background: User A tries to pay a ticket

#ESCENARIO 1
Scenario: User A tries to pay a ticket successfully
   #Given 3 tries to pay a ticket
    Then Payment from 3 is made successfully
    And Payment from 3 returns success message

#Error en el que falla la transaccion bancaria
#ESCENARIO 2
Scenario: User tries to pay a ticket with transaction error message
    #Given 4 tries to pay a ticket with error
    Then Payment made from 4 is not made
    And Payment made from 4 returns transaction error message bank code invalid

#Error en el que no hay dinero 
#ESCENARIO 3
Scenario: User tries to pay a ticket with funds error message
  	#Given 5 tries to pay a ticket with no funds error message
    Then Payment made from 5 returns an error card declined
    And Payment made from 5 returns lack of funds error message
    
#ESCENARIO 4
Scenario: User tries to pay a ticket with error message about security code
  	#Given 6 tries to pay a ticket with error message about security code
    Then Payment made from 6 returns invalid card security code error
    And Payment made from 6 returns invalid card security code error message
    
#ESCENARIO 5
Scenario: User tries to pay a ticket with error message about account blocked
  	#Given 7 tries to pay a ticket with error message about account blocked
    Then Payment made from 7 returns account blocked error
    And Payment made from 7 returns account blocked error message
    
#ESCENARIO PRUEBA
Scenario Outline: User tries to pay a ticket 
  	Given <ticket_id> tries to pay a ticket 
    Then Payment made from <ticket_id> 
    And Payment made from <ticket_id> returns message
     
    #Ejemplos de posibles resultados
    Examples: 
      | ticket_id   | random 	| status 					       |description                 |
      |  3				  |  799   	| OK			 				       | Pago aceptado              |
      |	 4				  |	 899	  | ERROR_BANK    	       | Bank code invalid          |
      |	 5			    |	 959	  | ERROR_DECLINED         | Card declined              |
      |  6          |  929    | ERROR_CARDSECURITYCODE | Invalid card security code |
      |	 7			    |	 991	  | ERROR_ACCOUNTBLOCKED   | Account blocked            |