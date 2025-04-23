package br.iff.edu.bancodepalavras.dominio.palavra;

import br.iff.edu.bancodepalavras.dominio.tema.Tema;

public interface PalavraFactory {
	
	public Palavra getPalavra(String p, Tema tema);
}
