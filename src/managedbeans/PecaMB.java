package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.PecaDAOImpl;
import dao.PecaDao;
import model.Peca;

@ManagedBean
@SessionScoped
public class PecaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Peca pecaAtual = new Peca();
	private PecaDao pecaDAO = new PecaDAOImpl();
	private List<Peca> pecas = new ArrayList<Peca>();
	public Peca getPecaAtual() {
		return pecaAtual;
	}
	public void setPecaAtual(Peca pecaAtual) {
		this.pecaAtual = pecaAtual;
	}
	public PecaDao getPecaDAO() {
		return pecaDAO;
	}
	public void setPecaDAO(PecaDao pecaDAO) {
		this.pecaDAO = pecaDAO;
	}
	public List<Peca> getPecas() {
		return pecas;
	}
	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
