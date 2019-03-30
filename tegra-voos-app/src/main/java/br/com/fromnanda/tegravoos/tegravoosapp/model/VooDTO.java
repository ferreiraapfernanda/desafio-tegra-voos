package br.com.fromnanda.tegravoos.tegravoosapp.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.springframework.format.annotation.DateTimeFormat;

public class VooDTO {

	private String origem;
	private String destino;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime saida;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime chegada;
	private ArrayList<Escala> trechos;
	private BigDecimal precoTotal;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime tempoTotal;

	public VooDTO() {
		super();
	}

	public VooDTO(String origem, String destino, LocalDateTime saida, LocalDateTime chegada,
			ArrayList<Escala> trechos) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.saida = saida;
		this.chegada = chegada;
		this.trechos = trechos;

		calculaPrecoTotal();
		calculaTempoTotal();
	}

	public void calculaTempoTotal() {

		int qtdEscalas = this.trechos.size();

		LocalDateTime saidaEscala = this.trechos.get(0).getSaida();
		LocalDateTime chegadaEscala = this.trechos.get(qtdEscalas - 1).getChegada();

		Duration dur = Duration.between(saidaEscala, chegadaEscala);
		long millis = dur.toMillis();

		Integer horas = (int) TimeUnit.MILLISECONDS.toHours(millis);
		Integer minutos = (int) (TimeUnit.MILLISECONDS.toMinutes(millis)
				- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)));

		tempoTotal = LocalTime.of(horas, minutos);

	}

	public void calculaPrecoTotal() {
		precoTotal = this.trechos.stream().map(Escala::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);
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

	public ArrayList<Escala> getTrechos() {
		return trechos;
	}

	public void setTrechos(ArrayList<Escala> trechos) {
		this.trechos = trechos;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public LocalTime getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(LocalTime tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

}
