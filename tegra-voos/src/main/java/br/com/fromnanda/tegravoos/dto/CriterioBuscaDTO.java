package br.com.fromnanda.tegravoos.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("CriterioBuscaDTO")
public class CriterioBuscaDTO {

	@JsonProperty
	@ApiModelProperty(value = "Sigla do Aeroporto de Origem", required = true, example = "VIX")
	private String origem;
	@JsonProperty
	@ApiModelProperty(value = "Sigla do Aeroporto de Destino", required = true, example = "AJU")
	private String destino;
	@JsonProperty
	@ApiModelProperty(value = "Data do voo", required = true, example = "2019-02-10")
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
