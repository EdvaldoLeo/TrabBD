package dao;

import java.sql.SQLException;
import java.util.List;

import model.OrdemServico;


public interface OservicoDao {

	public void adicionar(OrdemServico o) throws ClassNotFoundException, SQLException;

	public void alterar(OrdemServico o) throws ClassNotFoundException, SQLException;

	public void remover(OrdemServico o) throws ClassNotFoundException, SQLException;

	public OrdemServico buscarPorNumero(int n) throws ClassNotFoundException, SQLException;

	public List<OrdemServico> listarPorStatus(String t) throws ClassNotFoundException, SQLException;
	
	public List<OrdemServico> listar() throws ClassNotFoundException, SQLException;
}
