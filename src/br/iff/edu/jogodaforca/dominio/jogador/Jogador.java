package br.iff.edu.jogodaforca.dominio.jogador;

import br.iff.edu.jogodaforca.dominio.ObjetoDominioImpl;

public class Jogador extends ObjetoDominioImpl {

	private String nome;
	private int pontuacao = 0;
	
	private Jogador(long id, String nome) {
		super(id);
		this.nome = nome;
	}
	private Jogador(long id, String nome, int pontuacao) {
		super(id);
		this.nome = nome;
		this.pontuacao = pontuacao;
	}
	
	public static Jogador criar(long id, String nome) {
		return new Jogador(id, nome);
	}
	
	public static Jogador reconstituir(long id, String nome, int pontuacao) {
		return new Jogador(id, nome, pontuacao);
	}
	
	public String getNome() {
		return this.nome;
	}
	public String setNome(String nome) {
		if(nome != null) {
			this.nome = nome;
		}
		throw new IllegalArgumentException("Nome não pode ser nulo");
	}
	public int getPontuacao() {
		return this.pontuacao;
	}
	public void atualizarPontuacao(int pontos) {
		if(pontos >= 0) {
			this.pontuacao = pontos;
		}
		throw new IllegalArgumentException("A pontuação não pode ser negativa!");
	}
}
