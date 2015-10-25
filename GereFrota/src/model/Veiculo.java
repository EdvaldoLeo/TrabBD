package model;

import java.util.Date;

public class Veiculo {
	String placa;
	String chassi;
	String marca;
	String modelo;
	Date anoFabricacao;
	Date anoModelo;
	String carroceria;
	int capacidadeCarga;
	int kmTrocaOleo;
	Date exerLicenciamento;
	Date dataDocumento;
	String status;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		if(!placa.isEmpty()){
			placa = placa.toUpperCase();
		}
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		if(chassi!=null){
			chassi = chassi.toUpperCase();
		}
		this.chassi = chassi;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if(marca!=null){
			marca = marca.toUpperCase();
		}
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if(modelo!=null){
			modelo = modelo.toUpperCase();
		}
		this.modelo = modelo;
	}

	public Date getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Date anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Date getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Date anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(String carroceria) {
		if(carroceria!=null){
			carroceria = carroceria.toUpperCase();
		}
		this.carroceria = carroceria;
	}

	public int getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(int capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

	public int getKmTrocaOleo() {
		return kmTrocaOleo;
	}

	public void setKmTrocaOleo(int kmTrocaOleo) {
		this.kmTrocaOleo = kmTrocaOleo;
	}

	public Date getExerLicenciamento() {
		return exerLicenciamento;
	}

	public void setExerLicenciamento(Date exerLicenciamento) {
		this.exerLicenciamento = exerLicenciamento;
	}

	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if(status!=null){
			status = status.toUpperCase();
		}
		this.status = status;
	}
}
