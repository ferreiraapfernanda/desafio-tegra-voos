package br.com.fromnanda.tegravoos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Voo {

	@JsonProperty
	private String origem;
	@JsonProperty
	private String destino;
	@JsonProperty(access = Access.WRITE_ONLY)
	private LocalDateTime data;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String voo;
	@JsonProperty
	private LocalDateTime saida;
	@JsonProperty
	private LocalDateTime chegada;
	@JsonProperty
	private BigDecimal preco;

	public Voo() {

	}

	/**
	 * 
	 * @param origem
	 * @param destino
	 * @param data
	 * @param voo
	 * @param saida
	 * @param chegada
	 * @param preco
	 */
	public Voo(String origem, String destino, LocalDateTime data, String voo, LocalDateTime saida,
			LocalDateTime chegada, BigDecimal preco) {
		this.origem = origem;
		this.destino = destino;
		this.data = data;
		this.voo = voo;
		this.saida = saida;
		this.chegada = chegada;
		this.preco = preco;
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

	public String getVoo() {
		return voo;
	}

	public void setVoo(String voo) {
		this.voo = voo;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
