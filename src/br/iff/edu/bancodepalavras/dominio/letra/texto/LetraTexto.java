package br.iff.edu.bancodepalavras.dominio.letra.texto;

import br.iff.edu.bancodepalavras.dominio.letra.Letra;

public class LetraTexto extends Letra {

	public LetraTexto(long id, char codigo) {
		super(id, codigo);
	}
	
	@Override
	public void exibir(Object context) {
		System.out.println(this.getCodigo());
	}

}
