package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.OservicoDao;
import dao.OservicoDaoImp;
import dao.VeiculoDao;
import dao.VeiculoDaoImp;
import model.OrdemServico;
import model.Veiculo;

@ManagedBean
@SessionScoped
public class OservicoMB implements Serializable {

	private static final long serialVersionUID = -8234673211445524887L;
	private OrdemServico osAtual = new OrdemServico();
	private OservicoDao os = new OservicoDaoImp();
	private List<OrdemServico> oss = new ArrayList<OrdemServico>();
	private boolean mostrarVeiculo = false;

	public OrdemServico getOsAtual() {
		return osAtual;
	}

	public void setOsAtual(OrdemServico osAtual) {
		this.osAtual = osAtual;
	}

	public List<OrdemServico> getOss() {
		return oss;
	}

	public void setOss(List<OrdemServico> oss) {
		this.oss = oss;
	}

	public String refresh() {
		osAtual = new OrdemServico();
		mostrarVeiculo = false;
		return "";
	}

	public String adicionar() {

		try {
			os.adicionar(osAtual);
			osAtual = new OrdemServico();
			mostrarVeiculo = false;
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Ordem Serviço adicionada com sucesso!", ""));
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao adicionar a ordem de servico!", ""));
			e.printStackTrace();
		}
		return "";
	}

	public String buscarPorNumero() {
		try {

			OrdemServico o = os.buscarPorNumero(osAtual.getNumero());
			if (o != null) {
				osAtual = o;
				mostrarVeiculo = true;
			} else {
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Ordem de Serviço não cadastrada!", ""));
			}
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao buscar a ordem de servico!", ""));
			e.printStackTrace();
		}
		return "";

	}

	public String buscarPorPlaca() {
		VeiculoDao veicDao = new VeiculoDaoImp();
		try {

			Veiculo v = veicDao.buscarPorPlaca(osAtual.getVeiculo().getPlaca());

			if (v != null) {
				osAtual.setVeiculo(v);
				mostrarVeiculo = true;
			} else {
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Veículo não cadastrado!", ""));
			}
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar veículos!", ""));
			e.printStackTrace();
		}
		return "";
	}

	public boolean getMostrarVeiculo() {
		return mostrarVeiculo;
	}

	public void setMostrarVeiculo(boolean mostrarVeiculo) {
		this.mostrarVeiculo = mostrarVeiculo;
	}

}
