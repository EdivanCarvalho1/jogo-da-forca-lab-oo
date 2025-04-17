package br.iff.edu.dominio.palavra;

import br.iff.edu.dominio.ObjetoDominioImpl;
import br.iff.edu.dominio.letra.Letra;
import br.iff.edu.dominio.tema.Tema;

public class Palavra extends ObjetoDominioImpl {
	
	private String palavra;
	
	private Tema tema;
	
	private Letra[] letras;
	
	private Palavra(Long id, String palavra, Tema tema) {
		super(id);
		this.palavra = palavra;
		this.tema = tema;
		this.letras = new Letra[palavra.length()];
	}
	
	
}
