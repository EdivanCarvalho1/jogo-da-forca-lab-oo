package br.iff.edu.jogodaforca.dominio.rodada;

import br.iff.edu.jogodaforca.dominio.jogador.Jogador;

public interface RodadaFactory {
	public Rodada getRodada(Jogador jogador);
}
