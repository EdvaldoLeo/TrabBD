package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdemServico {
	
	private int numero;
	private Date data;
	private int kmServico;
	private String descricao;
	private String status;
	private Veiculo veiculo = new Veiculo();
	private List<Peca> peca = new ArrayList<Peca>();
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getKmServico() {
		return kmServico;
	}
	public void setKmServico(int kmServico) {
		this.kmServico = kmServico;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public List<Peca> getPeca() {
		return peca;
	}
	public void setPeca(List<Peca> peca) {
		this.peca = peca;
	}
	
	
}
