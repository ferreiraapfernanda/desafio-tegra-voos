package br.com.fromnanda.tegravoos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Voo implements Comparable<Voo> {

	@JsonProperty
	private String origem;
	@JsonProperty
	private String destino;
	@JsonProperty(access = Access.WRITE_ONLY)
	private LocalDate data;

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
	public Voo(String origem, String destino, LocalDate data, String voo, LocalDateTime saida, LocalDateTime chegada,
			BigDecimal preco) {
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
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

	@Override
	public int compareTo(Voo outroVoo) {

		LocalDate d1 = this.saida.toLocalDate();
		LocalDate d2 = outroVoo.saida.toLocalDate();

		if (d1.isBefore(d2)) {
			return -1;
		}

		if (d1.isAfter(d2)) {
			return 1;
		}

		return 0;
	}

}
