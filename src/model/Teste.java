package model;

//trabalho de BD

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.sun.faces.taglib.jsf_core.ConvertDateTimeTag;

import dao.VeiculoDaoImp;
import dao.DatabaseConnection;
import dao.FornecedorDao;
import dao.FornecedorDaoImp;
import dao.VeiculoDao;
import servicos.EnumStatusVeiculo;

public class Teste {

	public static void main(String[] args) throws ParseException {
		
		
		/*FornecedorDao dao = new FornecedorDaoImp();
		Fornecedor f = null;
		try {
			f = dao.buscarPorCnpj("22222222222222");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(f.getNome());*/
		
		
		/*Fornecedor f = new Fornecedor();
		f.setCnpj("22222222222222");
		f.setNome("aaaaaaaaaaaa");
		f.setCep("11111111");
		f.setRua("aaaaaaaaaaa");
		f.setNum("1111");
		f.setCompl("aaaaaaaaa");
		f.setBairro("aaaaaaaa");
		f.setCidade("aaaaaaa");
		f.setUf("aa");
		f.setFone1("11111111111");
		f.setFone2("22222222222");
		f.setStatus("ATIVO");
		f.setContato("aaaaaaaaa");
		f.setObservacao("aaaaaaaaaaaa");
		
		
		FornecedorDao dao = new FornecedorDaoImp();
		try {
			dao.adicionar(f);
			System.out.println("certo");
		} catch (ClassNotFoundException e) {
			System.out.println("erro class");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("erro sql");
			e.printStackTrace();
		}
		*/
			
			
		//DateFormat formatter = new SimpleDateFormat("yyyy");  
		
		//Veiculo v = new Veiculo();
		//v.marca = "GM";
		//v.modelo = "corsa";
		//v.anoFabricacao = new java.sql.Date(((java.util.Date)formatter.parse("2010")).getTime());
		//v.anoModelo = new java.sql.Date(((java.util.Date)formatter.parse("2011")).getTime());
		//v.status = EnumStatusVeiculo.DISPONIVEL.toString();
		//v.placa = "dde0909";

		//VeiculoDao dv = new VeiculoDaoImp();
		//dv.adicionar(v);

		// List<Veiculo> vs = d.listarPorPlaca("d");
		// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// Date date = new Date();
		// System.out.println(dateFormat.format(date));

		
		/*try {
			Connection con = DatabaseConnection.getConnection();
			if (con != null) {
				JOptionPane.showMessageDialog(null, "Conexão Efetuada com sucesso!");
			}

		 }
		  
		  catch (ClassNotFoundException ex) { ex.printStackTrace(); }
		  
		  catch (SQLException ex) { JOptionPane.showMessageDialog(null,
		  "Erro na conexão!"); ex.printStackTrace(); }
		  
		  }*/
		 
	}
	
}
