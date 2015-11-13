package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection con;

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		
		// Configuração dos parâmetros de conexão
        String server = "localhost";
        String port = "1521";               // Porta TCP padrão do Oracle
        String database = "xe";

        // Configuração dos parâmetros de autenticação
        String user = "root";
        String pwd = "fatec";
        
		if (con == null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}		 
		con = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":" + port + ":"+ database ,user,pwd);
		
		return con;
	}

}
