package br.com.fromnanda.tegravoos.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriterioBuscaDTO {

	@JsonProperty
	private String origem;
	@JsonProperty
	private String destino;
	@JsonProperty
	private LocalDateTime data;

	public CriterioBuscaDTO() {

	}

	/**
	 * 
	 * @param origem
	 * @param destino
	 * @param data
	 */
	public CriterioBuscaDTO(String origem, String destino, LocalDateTime data) {
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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}
