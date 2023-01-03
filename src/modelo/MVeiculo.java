package modelo;

import java.time.LocalDate;

public class MVeiculo {
	Integer
			wIDVeiculo;

	String	
			wPlaca,
			wTipoVeiculo,
			wCor,
			wMarca,
			wCombustivel,
			wNacional,
			wDonoVeiculo;
	LocalDate
			wAnoModelo;
	
	
	public String getwDonoVeiculo() {
		return wDonoVeiculo;
	}

	public void setwDonoVeiculo(String wDonoVeiculo) {
		this.wDonoVeiculo= wDonoVeiculo;
	}
	public Integer getwIDVeiculo() {
		return wIDVeiculo;
	}

	public void setwIDVeiculo(Integer wIDVeiculo) {
		this.wIDVeiculo = wIDVeiculo;
	}
	
	public LocalDate getwAnoModelo() {
		return wAnoModelo;
	}

	public void setwAnoModelo(LocalDate wAnoModelo) {
		this.wAnoModelo = wAnoModelo;
	}

	public String getwNacional() {
		return wNacional;
	}

	public void setwNacional(String wNacional) {
		this.wNacional = wNacional;
	}

	public String getwPlaca() {
		return wPlaca;
	}

	public void setwPlaca(String wPlaca) {
		this.wPlaca = wPlaca;
	}
	
	public String getwTipoVeiculo() {
		return wTipoVeiculo;
	}

	public void setwTipoVeiculo(String wTipoVeiculo) {
		this.wTipoVeiculo = wTipoVeiculo;
	}

	public String getwCor() {
		return wCor;
	}

	public void setwCor(String wCor) {
		this.wCor = wCor;
	}

	public String getwMarca() {
		return wMarca;
	}

	public void setwMarca(String wMarca) {
		this.wMarca = wMarca;
	}

	public String getwCombustivel() {
		return wCombustivel;
	}

	public void setwCombustivel(String wCombustivel) {
		this.wCombustivel = wCombustivel;
	}

			
}
