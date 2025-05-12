package br.iff.edu.bancodepalavras.dominio.letra.imagem;

import br.iff.edu.bancodepalavras.dominio.letra.Letra;

public class LetraImagem extends Letra {

	public LetraImagem(char codigo) {
		super(codigo);
	}
	
	@Override
	public void exibir(Object context) {
		System.out.println(" ");
	}

}
