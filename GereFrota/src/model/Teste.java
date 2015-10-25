package model;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import servicos.EnumStatusVeiculo;

public class Teste {

	public static void main(String[] args) {
		
		 Veiculo v = new Veiculo();
		 v.marca = "GM";
		 //v.anoFabricacao = 2010;
		 //v.anoModelo = 2011; 
		 v.placa = "ddd0909";
		 v.status="DISPONIVEL";
		
		//IDaoVeiculo dv = new DaoVeiculo();
		//CtrVeiculo d = new CtrVeiculo();
		//dv.adicionar(v);
		
		//List<Veiculo> vs = d.listarPorPlaca("d");
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		 Date date = new Date(); 		
		System.out.println(dateFormat.format(date));
		

	}

}
