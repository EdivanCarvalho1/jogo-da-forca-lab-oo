package br.iff.edu.bancodepalavras.dominio.tema;

import br.iff.edu.jogodaforca.dominio.ObjetoDominioImpl;

public class Tema extends ObjetoDominioImpl {
	
	private String nome;
	
	private Tema(Long id, String nome) {
		super(id);
		this.setNome(nome);
	}
	
	private final void setNome(String nome) {
		if(nome == null || nome.trim() == "") {
			throw new IllegalArgumentException("Nome não pode ser nulo ou vazio!");
		}
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public static Tema criar(Long id, String nome) {
		return new Tema(id, nome);
	}
	
	public static Tema reconstituir(Long id, String nome) {
		return new Tema(id, nome);
	}
	
	public String toString() {
		return "id="+ this.getId();
	}
}
