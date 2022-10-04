package com.grupo01.spring.util;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("script")
public class ScriptBBDD {
	
	private static final Logger log = LoggerFactory.getLogger(ScriptBBDD.class);

	public static void deCSVaMySQL() {
		String jdbcURL = "jdbc:mysql://localhost:3306/...?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "Ihpo8Jin";

		Connection connection = null;

		try {

		connection = DriverManager.getConnection(jdbcURL, username, password);
		connection.setAutoCommit(false);

		//Aqui inicializaremos BBDD
		Statement statement = connection.createStatement();
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS `minigametable` (     `User_id` int(11) NOT NULL AUTO_INCREMENT, `Nombre` varchar(45) NOT NULL,    `Apellidos` varchar(45) NOT NULL,  `Mail` varchar(45) NOT NULL,  `Contrasenna` varchar(45) NOT NULL, `FechaAlta` date(11) NOT NULL,  PRIMARY KEY (`User_id`) ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;");
                                                                                                                                                                                                                                                                    //Formato: YYYY-MM-DD
        
        connection.commit();
        connection.close();
        
		log.info("Base de datos creada.: ");
		
		} catch (SQLException ex) {
            ex.printStackTrace();
 
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	 }

}
