package br.iff.edu.jogodaforca;

import br.iff.edu.bancodepalavras.dominio.palavra.PalavraRepository;
import br.iff.edu.bancodepalavras.dominio.tema.TemaRepository;
import br.iff.edu.jogodaforca.dominio.jogador.JogadorRepository;
import br.iff.edu.jogodaforca.dominio.rodada.RodadaRepository;

public interface RepositoryFactory {
	
	public PalavraRepository getPalavraRepository();
	
	public TemaRepository getTemaRepository();
	
	public RodadaRepository getRodadaRepository();
	
	public JogadorRepository getJogadorRepository();
}
