package br.iff.edu.jogodaforca.dominio.rodada;

import br.iff.edu.bancodepalavras.dominio.palavra.PalavraRepository;
import br.iff.edu.bancodepalavras.dominio.tema.TemaRepository;
import br.iff.edu.factory.EntityFactory;
import br.iff.edu.jogodaforca.dominio.jogador.Jogador;

public class RodadaFactoryImpl extends EntityFactory implements RodadaFactory {
	
	private TemaRepository temaRepository;
	private PalavraRepository palavraRepository;
	
	protected RodadaFactoryImpl(RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		super(rodadaRepository);
		this.temaRepository = temaRepository;
		this.palavraRepository = palavraRepository;
	}
	
	protected RodadaRepository getRodadaRepository() {
		return (RodadaRepository) this.getRepository();
	}
	
	protected TemaRepository getTemaRepository() {
		return this.temaRepository;
	}
	
	protected PalavraRepository getPalavraRepository() {
		return this.palavraRepository;
	}
	
	@Override
	public Rodada getRodada(Jogador jogador) {
		// TODO Auto-generated method stub
		return null;
	}
}
