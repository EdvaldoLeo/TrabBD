package model;

//trabalho de BD

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.sun.faces.taglib.jsf_core.ConvertDateTimeTag;

import dao.VeiculoDaoImp;
import dao.DatabaseConnection;
import dao.VeiculoDao;
import servicos.EnumStatusVeiculo;

public class Teste {

	public static void main(String[] args) throws ParseException {

		
		DateFormat formatter = new SimpleDateFormat("yyyy");  
		
		Veiculo v = new Veiculo();
		v.marca = "GM";
		v.modelo = "corsa";
		v.anoFabricacao = new java.sql.Date(((java.util.Date)formatter.parse("2010")).getTime());
		v.anoModelo = new java.sql.Date(((java.util.Date)formatter.parse("2011")).getTime());
		v.status = EnumStatusVeiculo.DISPONIVEL.toString();
		v.placa = "dde0909";

		VeiculoDao dv = new VeiculoDaoImp();
		dv.adicionar(v);

		// List<Veiculo> vs = d.listarPorPlaca("d");
		// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// Date date = new Date();
		// System.out.println(dateFormat.format(date));

		/*
		 * try { Connection con = DatabaseConnection.getConnection(); if (con!=
		 * null) { JOptionPane.showMessageDialog(null,
		 * "Conexão Efetuada com sucesso!"); }
		 * 
		 * 
		 * }
		 * 
		 * catch (ClassNotFoundException ex) { ex.printStackTrace(); }
		 * 
		 * catch (SQLException ex) { JOptionPane.showMessageDialog(null,
		 * "Erro na conexão!"); ex.printStackTrace(); }
		 * 
		 * }
		 */

	}
}
