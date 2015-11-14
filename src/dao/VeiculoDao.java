package dao;

import java.util.List;

import model.Veiculo;

public interface VeiculoDao {

	public void adicionar(Veiculo v);

	public void alterar(Veiculo v);

	public void remover(Veiculo v);

	public Veiculo buscarPorPlaca(String t);

	public List<Veiculo> listarPorStatus(String t);
	
	public List<Veiculo> listar();
	
}
