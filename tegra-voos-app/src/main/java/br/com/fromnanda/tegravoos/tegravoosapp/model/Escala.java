package br.com.fromnanda.tegravoos.tegravoosapp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Escala {

	private String origem;
	private String destino;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime saida;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime chegada;
	private BigDecimal preco;

	public Escala() {
		super();
	}

	public Escala(String origem, String destino, LocalDateTime saida, LocalDateTime chegada, BigDecimal preco) {
		super();
		this.origem = origem;
		this.destino = destino;
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
