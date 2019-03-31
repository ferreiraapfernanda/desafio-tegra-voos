package br.com.fromnanda.tegravoos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Voo")
public class Voo implements Comparable<Voo> {

	@JsonProperty
	@ApiModelProperty(value = "Sigla do Aeroporto de Origem", required = true, example = "VIX")
	private String origem;
	@JsonProperty
	@ApiModelProperty(value = "Sigla do Aeroporto de Destino", required = true, example = "AJU")
	private String destino;
	@ApiModelProperty(value = "Data de saída do voo", required = true, example = "2019-02-10")
	@JsonProperty(access = Access.WRITE_ONLY)
	private LocalDate data;
	@ApiModelProperty(value = "Campo identificador do voo", required = true, example = "A123B456")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String voo;
	@JsonProperty
	@ApiModelProperty(value = "Data e hora de saída do voo", required = true, example = "2019-02-10T18:30:00")
	private LocalDateTime saida;
	@JsonProperty
	@ApiModelProperty(value = "Data e hora de chegada do voo", required = true, example = "2019-02-10T18:30:00")
	private LocalDateTime chegada;
	@JsonProperty
	@ApiModelProperty(value = "Preco da passagem", required = true, example = "300.00")
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
