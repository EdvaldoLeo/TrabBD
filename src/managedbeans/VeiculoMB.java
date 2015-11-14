package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.VeiculoDaoImp;
import dao.VeiculoDao;
import model.Veiculo;

@ManagedBean
@SessionScoped
public class VeiculoMB implements Serializable {

	private static final long serialVersionUID = -7432112812752393705L;
	private Veiculo veicAtual = new Veiculo();;
	private VeiculoDao veicDAO = new VeiculoDaoImp();;
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();;

	public Veiculo getVeicAtual() {
		return veicAtual;
	}

	public void setVeicAtual(Veiculo veicAtual) {
		this.veicAtual = veicAtual;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public String adicionar() {

		try {
			veicDAO.adicionar(veicAtual);
			veicAtual = new Veiculo();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Veiculo adicionado com sucesso!", "TESTE");
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public String carregar(Veiculo v) {
		try {
			veicAtual = v;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public String atualizar() {
		try {
			veicDAO.alterar(veicAtual);
			veicAtual = new Veiculo();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Veiculo atualizado com sucesso!", "");
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public String remover(Veiculo v) {
		try {
			veicDAO.remover(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public String listarPorStatus(String t) {
		try {
			veiculos = veicDAO.listarPorStatus(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public String listarTodos() {
		try {
			veiculos = veicDAO.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public String buscarPorPlaca() {
		try {
			veicAtual = veicDAO.buscarPorPlaca(veicAtual.getPlaca());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
