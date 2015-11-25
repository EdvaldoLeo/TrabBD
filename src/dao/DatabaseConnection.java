package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection con;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		// Configuração dos parâmetros de conexão
		String server = "localhost";
		String port = "1521"; // Porta TCP padrão do Oracle
		String sid = "xe";

		// Configuração dos parâmetros de autenticação
		String user = "root";
		String pwd = "aluno";

		if (con == null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		con = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":" + port + ":" + sid, user, pwd);

		return con;
	}

}
