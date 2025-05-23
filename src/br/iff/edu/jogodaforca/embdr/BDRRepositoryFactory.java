package br.iff.edu.jogodaforca.embdr;

import br.iff.edu.bancodepalavras.dominio.palavra.PalavraRepository;
import br.iff.edu.bancodepalavras.dominio.tema.TemaRepository;
import br.iff.edu.jogodaforca.RepositoryFactory;
import br.iff.edu.jogodaforca.dominio.jogador.JogadorRepository;
import br.iff.edu.jogodaforca.dominio.rodada.RodadaRepository;

public class BDRRepositoryFactory implements RepositoryFactory{
	
	private static BDRRepositoryFactory soleInstance;
	
	private BDRRepositoryFactory() {
	}

	public static BDRRepositoryFactory getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BDRRepositoryFactory();
		}
		return soleInstance;
	}
	
	@Override
	public PalavraRepository getPalavraRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TemaRepository getTemaRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RodadaRepository getRodadaRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JogadorRepository getJogadorRepository() {
		// TODO Auto-generated method stub
		return null;
	}

}
