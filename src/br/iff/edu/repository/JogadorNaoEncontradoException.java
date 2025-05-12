package br.iff.edu.repository;

public class JogadorNaoEncontradoException extends Exception {
	
	/**
	 * 
	 */
	private String jogador;
	
	private static final long serialVersionUID = 1L;

	public JogadorNaoEncontradoException() {
		super();
	}

	public JogadorNaoEncontradoException(String jogador) {
		super("");
		this.jogador = jogador;
		System.out.println("Jogador " + this.getJogador() + " não encontrado.");
	}

	public String getJogador() {
		return jogador;
	}

}
