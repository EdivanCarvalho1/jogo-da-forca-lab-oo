package br.iff.edu.bancodepalavras.dominio.letra.texto;

import br.iff.edu.bancodepalavras.dominio.letra.Letra;

public class LetraTexto extends Letra {

	public LetraTexto(char codigo) {
		super(codigo);
	}
	
	@Override
	public void exibir(Object context) {
		System.out.print(this.getCodigo());
	}

}
