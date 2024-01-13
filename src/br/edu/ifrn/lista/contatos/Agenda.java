package br.edu.ifrn.lista.contatos;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import br.edu.ifrn.lista.extra.Persistencia;

public class Agenda implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4056011541392246693L;
	private ArrayList<Contato> ctt = new ArrayList<>();
	private int quant;

	public Agenda() {
		setQuant(1);
	}

	public boolean inserir(String nome, String telefone, String endereco, String tipoSanguineo) {
		ctt.add(new Contato(nome, telefone, endereco ,tipoSanguineo));
		setQuant(getQuant() + 1);
		return true;
	}

	public Contato buscar(String nome) {
		for (int i = 0; i < ctt.size(); i++) {
			if (ctt.get(i).getNome().equalsIgnoreCase(nome)) {
				return ctt.get(i);
			}
		}
		return null;
	}

	public boolean remover(String nome) {
		for (int i = 0; i < ctt.size(); i++) {
			if (ctt.get(i).getNome().equals(nome)) {
				ctt.remove(i);
				setQuant(getQuant() - 1);
				return true;
			}
		}
		return false;
	}

	public void ordernar(){
		Collections.sort(ctt);
	}

	public Contato getContato(int i) {
		return ctt.get(i);
	}

	public int getQuantContatos() {
		return ctt.size();
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public void salvar(String c) {
		Persistencia.serializaGrava(c+".txt", ctt);
	}

	@SuppressWarnings("unchecked")
	public void carregar() {
		try {
			ctt = (ArrayList<Contato>)Persistencia.leDeserializa("teste.txt");
			quant = ctt.size();
		} catch (ClassNotFoundException | IOException e) {
			// TODO: handle 
			e.printStackTrace();
		}
	}
	
}
