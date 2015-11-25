package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import dao.FornecedorDaoImp;
import dao.FornecedorDao;
import model.Fornecedor;

@ManagedBean
@SessionScoped
public class FornecedorMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4609510732091535660L;
	private Fornecedor fornAtual = new Fornecedor();
	private FornecedorDao fornDAO = new FornecedorDaoImp();
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

	public Fornecedor getFornAtual() {
		return fornAtual;
	}

	public void setFornAtual(Fornecedor fornAtual) {
		this.fornAtual = fornAtual;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public void refresh() {
		fornAtual = new Fornecedor();
	}

	public String adicionar() {

		try {
			fornDAO.adicionar(fornAtual);
			refresh();
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornecedor adicionado com sucesso!", ""));
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao adicionar o fornecedor!", ""));
			e.printStackTrace();
		}
		return "";
	}

	public String atualizar() {
		try {
			fornDAO.alterar(fornAtual);
			refresh();
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornecedor atualizado com sucesso!", ""));
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar o fornecedor!", ""));
			e.printStackTrace();
		}
		return "";
	}

	public String remover(Fornecedor v) {
		try {
			fornDAO.remover(v);
			refresh();
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornecedor excluido com sucesso!", ""));
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir o fornecedor!", ""));
			e.printStackTrace();
		}
		return "";
	}

	public String listarTodos() {
		try {
			fornecedores = fornDAO.listar();
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar fornecedores!", ""));
			e.printStackTrace();
		}
		return "";
	}

	public String buscarPorCnpj() {
		try {
			Fornecedor f = fornDAO.buscarPorCnpj(fornAtual.getCnpj());
			if (f != null) {
				fornAtual = f;
			} else {
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornecedor não cadastrado!", ""));
			}
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao buscar Fornecedor!", ""));
			e.printStackTrace();
		}
		return "";
	}

}
