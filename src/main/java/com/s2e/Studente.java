package com.s2e;


public class Studente {
	
	
	private String nome;
	
	
	private String cognome;
	
	public Studente() {
		nome = "pluto";
		cognome = "pippo";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

}
