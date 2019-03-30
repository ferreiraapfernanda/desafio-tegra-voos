package br.com.fromnanda.tegravoos.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Aeroporto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String nome;
	@JsonProperty
	private String sigla;
	@JsonProperty
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
