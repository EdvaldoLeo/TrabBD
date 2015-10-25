package dao;

import java.util.List;

import model.Fornecedor;

public interface IDaoFornecedor {
	public void adicionar(Fornecedor f);

	public void alterar(Fornecedor f);

	public void remover(Fornecedor f);

	public List<Fornecedor> listarPorCnpj(String t);

	public List<Fornecedor> listarPorRazao(String t);

	public List<Fornecedor> listar();
}
