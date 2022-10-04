package com.grupo01.spring.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("script")
public class ScriptBBDD {

	private static final Logger log = LoggerFactory.getLogger(ScriptBBDD.class);
	
	public static void scriptBBDD() {
		String jdbcURL = "jdbc:mysql://localhost:3306/lucaticket?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "Ihpo8Jin";

 
        Connection connection = null;
        try {
        	 
            connection = DriverManager.getConnection(jdbcURL, username, password);
            
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `usuarios` (     `user_id` int(11) NOT NULL AUTO_INCREMENT, `Name` varchar(45) NOT NULL,    `Apellido` varchar(45) NOT NULL,    `Mail` varchar(45) NOT NULL,    `Contrasenna` varchar(45) NOT NULL,    `FechaAlta` date"
            		+ "(45) NOT NULL,    `NA_Sales` double,    `EU_Sales` double,    `JP_Sales` double,    `Other_Sales` double,    `Global_Sales` double,    PRIMARY KEY (`Rank`) ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;");
            
            
            connection.setAutoCommit(false);
            connection.commit();
            connection.close();
            
            log.info("Base de datos creada. ");
            
 
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
