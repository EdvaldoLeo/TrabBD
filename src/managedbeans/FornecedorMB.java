package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.FornecedorDao;
import dao.FornecedorDaoImp;
import model.Fornecedor;

@ManagedBean
@SessionScoped
public class FornecedorMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7687624675890520573L;

	// Em fornecedor precisa passar um cnpj por que eh assim que ta 
	// no construtor
	private Fornecedor fornecedorAtual = new Fornecedor("00000000000");
	
	private FornecedorDao fornecedorDAO = new FornecedorDaoImp();
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	public Fornecedor getFornecedorAtual(){
		return fornecedorAtual;
	}
	
	public FornecedorDao getFornecedorDAO(){
		return fornecedorDAO;
	}
	
	public void setFornecedorDao (FornecedorDao fornecedorDAO){
		this.fornecedorDAO = fornecedorDAO;
	}
	
	public List<Fornecedor> getFornecedores(){
		return fornecedores;
	}
	
	public void setFornecedores(List<Fornecedor> fornecedores ){
		this.fornecedores = fornecedores;
	}
	
	public static long getSerialversionuid(){
		return serialVersionUID;
	}
}
