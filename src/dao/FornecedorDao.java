package dao;

import java.sql.SQLException;
import java.util.List;

import model.Fornecedor;

public interface FornecedorDao {
	public void adicionar(Fornecedor f) throws ClassNotFoundException, SQLException;

	public void alterar(Fornecedor f) throws ClassNotFoundException, SQLException;

	public void remover(Fornecedor f) throws ClassNotFoundException, SQLException;;

	public Fornecedor buscarPorCnpj(String t) throws ClassNotFoundException, SQLException;;

	public List<Fornecedor> listarPorRazao(String t) throws ClassNotFoundException, SQLException;;

	public List<Fornecedor> listar() throws ClassNotFoundException, SQLException;;
}
