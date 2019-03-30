package br.com.fromnanda.tegravoos.tegravoosapp.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Voo {

	private String origem;
	private String destino;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;

	public Voo() {
	}

	public Voo(String origem, String destino, LocalDate data) {
		super();
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
