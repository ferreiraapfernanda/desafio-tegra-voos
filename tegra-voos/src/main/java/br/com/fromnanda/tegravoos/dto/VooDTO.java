package br.com.fromnanda.tegravoos.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.fromnanda.tegravoos.model.Voo;

public class VooDTO {

	@JsonProperty
	private String origem;
	@JsonProperty
	private String destino;
	@JsonProperty
	private LocalDateTime saida;
	@JsonProperty
	private LocalDateTime chegada;
	@JsonProperty
	private List<Voo> trechos;

	public VooDTO() {
		super();
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
