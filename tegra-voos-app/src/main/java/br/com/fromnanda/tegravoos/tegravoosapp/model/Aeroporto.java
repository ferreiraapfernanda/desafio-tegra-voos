package br.com.fromnanda.tegravoos.tegravoosapp.model;

import java.io.Serializable;

public class Aeroporto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String sigla;
	private String cidade;

	public Aeroporto() {
	}

	public Aeroporto(String nome, String sigla, String cidade) {
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
