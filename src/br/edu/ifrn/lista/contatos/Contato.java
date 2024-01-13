package br.edu.ifrn.lista.contatos;

import java.io.Serializable;
import java.lang.Comparable;

public class Contato implements Serializable, Comparable<Contato> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -427635787531437486L;
	private String nome;
	private String numero;
	private String endereco;
	private String tipoSanguineo;


	public Contato(String nome, String numero, String endereco, String tipoSanguineo) {
		this.nome = nome;
		this.numero = numero;
		this.endereco = endereco;
		this.tipoSanguineo = tipoSanguineo;
	}

	@Override
	public String toString() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public int compareTo(Contato o) {
		// TODO Auto-generated method stub
		return nome.compareTo(o.getNome());
	}

}
