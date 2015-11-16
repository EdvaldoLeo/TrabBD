package dao;

import java.sql.SQLException;
import java.util.List;

import model.Veiculo;

public interface VeiculoDao {

	public void adicionar(Veiculo v) throws ClassNotFoundException, SQLException;

	public void alterar(Veiculo v) throws ClassNotFoundException, SQLException;

	public void remover(Veiculo v) throws ClassNotFoundException, SQLException;

	public Veiculo buscarPorPlaca(String t) throws ClassNotFoundException, SQLException;

	public List<Veiculo> listarPorStatus(String t) throws ClassNotFoundException, SQLException;
	
	public List<Veiculo> listar() throws ClassNotFoundException, SQLException;
	
}
