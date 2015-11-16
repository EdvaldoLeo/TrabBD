package dao;

import java.util.List;

import model.Peca;



public interface PecaDao {

	public void adicionar(Peca p);
	
	public void excluir(int codigo) ;
	
	public void atualizar( Peca p) ;
	
	public List<Peca> pesquisar(String nome);
	
	public Peca buscar (int codigo);
	
}
