package br.com.fromnanda.tegravoos.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriterioBuscaDTO {

	@JsonProperty
	private String origem;
	@JsonProperty
	private String destino;
	@JsonProperty
	private LocalDate data;

	public CriterioBuscaDTO() {

	}

	/**
	 * 
	 * @param origem
	 * @param destino
	 * @param data
	 */
	public CriterioBuscaDTO(String origem, String destino, LocalDate data) {
		this.origem = origem;
		this.destino = destino;
		this.data = data;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}
