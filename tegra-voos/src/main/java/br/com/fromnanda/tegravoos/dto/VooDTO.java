package br.com.fromnanda.tegravoos.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.fromnanda.tegravoos.model.Voo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Voo DTO")
public class VooDTO {

	@JsonProperty
	@ApiModelProperty(value = "Sigla do Aeroporto de Origem", required = true, example = "VIX")
	private String origem;
	@JsonProperty
	@ApiModelProperty(value = "Sigla do Aeroporto de Destino", required = true, example = "AJU")
	private String destino;
	@JsonProperty
	@ApiModelProperty(value = "Data e hora de saída do voo", required = true, example = "2019-02-10T18:30:00")
	private LocalDateTime saida;
	@JsonProperty
	@ApiModelProperty(value = "Data e hora de chegada do voo", required = true, example = "2019-02-10T18:30:00")
	private LocalDateTime chegada;
	@JsonProperty
	@ApiModelProperty(value = "Trechos de voo", required = true)
	private List<Voo> trechos;

	public VooDTO() {
		
	}

	/**
	 * 
	 * @param origem
	 * @param destino
	 * @param saida
	 * @param chegada
	 * @param trechos
	 */
	public VooDTO(String origem, String destino, LocalDateTime saida, LocalDateTime chegada, List<Voo> trechos) {
		this.origem = origem;
		this.destino = destino;
		this.saida = saida;
		this.chegada = chegada;
		this.trechos = trechos;
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

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public LocalDateTime getChegada() {
		return chegada;
	}

	public void setChegada(LocalDateTime chegada) {
		this.chegada = chegada;
	}

	public List<Voo> getTrechos() {
		return trechos;
	}

	public void setTrechos(List<Voo> trechos) {
		this.trechos = trechos;
	}

}
