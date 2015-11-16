package model;

import java.io.Serializable;
import java.util.Date;

public class Peca implements Serializable{

	private int nfiscal;
	private String nome;
	private double valor;
	private int qtde;
	private String cnpjFornecedor;
	private int codigo;
	private String placa;
	private Date dtServico;
	
	
	public Peca() {
		dtServico = new Date();
	}
	
	
	
	public int getNfiscal() {
		return nfiscal;
	}
	public void setNfiscal(int nfiscal) {
		this.nfiscal = nfiscal;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public String getCnpjFornecedor() {
		return cnpjFornecedor;
	}
	public void setCnpjFornecedor(String cnpjFornecedor) {
		this.cnpjFornecedor = cnpjFornecedor;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Date getDtServico() {
		return dtServico;
	}
	public void setDtServico(Date dtServico) {
		this.dtServico = dtServico;
	}
	


	
}
