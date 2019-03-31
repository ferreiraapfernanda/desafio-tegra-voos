package br.com.fromnanda.tegravoos.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Aeroporto")
public class Aeroporto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty
	@ApiModelProperty(value = "Nome do aeroporto", required = true, example = "Aeroporto Internacional de Guarulhos")
	private String nome;
	@JsonProperty
	@ApiModelProperty(value = "Sigla do aeroporto", required = true, example = "GRU")
	private String sigla;
	@JsonProperty
	@ApiModelProperty(value = "Cidade onde está localizado o aeropotto", required = true, example = "Guarulhos")
	private String cidade;

	public Aeroporto() {

	}

	/**
	 * 
	 * @param nome
	 * @param sigla
	 * @param cidade
	 */
	public Aeroporto(String nome, String sigla, String cidade) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
