package dao;

import java.util.List;

import model.Veiculo;

public interface IDaoVeiculo {

	public void adicionar(Veiculo v);

	public void alterar(Veiculo v);

	public void remover(Veiculo v);

	public List<Veiculo> listarPorPlaca(String t);

	public List<Veiculo> listarPorStatus(String t);
	
	public List<Veiculo> listar();

	public List<String> listarPlacasAtivas();
}
