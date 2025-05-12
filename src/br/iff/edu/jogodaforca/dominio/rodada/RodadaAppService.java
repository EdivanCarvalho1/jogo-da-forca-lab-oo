package br.iff.edu.jogodaforca.dominio.rodada;

import br.iff.edu.jogodaforca.dominio.jogador.JogadorRepository;
import br.iff.edu.repository.JogadorNaoEncontradoException;
import br.iff.edu.repository.RepositoryException;

public class RodadaAppService {
	
	private static RodadaAppService soleInstance;
	
	private RodadaFactory rodadaFactory;
	
	private RodadaRepository rodadaRepository;
	
	private JogadorRepository jogadorRepository;
	
	private RodadaAppService(RodadaFactory rodadaFactory, RodadaRepository rodadaRepository,
			JogadorRepository jogadorRepository) {
		this.rodadaFactory = rodadaFactory;
		this.rodadaRepository = rodadaRepository;
		this.jogadorRepository = jogadorRepository;
	}
	
	public static RodadaAppService createSoleInstance(RodadaFactory rodadaFactory, RodadaRepository rodadaRepository, JogadorRepository jogadorRepository) {
		if (soleInstance == null) {
			soleInstance = new RodadaAppService(rodadaFactory, rodadaRepository, jogadorRepository);
		}
		return soleInstance;
	}

	public static RodadaAppService getSoleInstance() {
		if (soleInstance == null) {
			throw new IllegalStateException("Sole instance not created yet.");
		}
		return soleInstance;
	}
	
	public Rodada novaRodada(long id) {
		Rodada rodada = this.rodadaFactory.getRodada(this.jogadorRepository.getPorId(id));
		salvarRodada(rodada);
		return rodada;
	}
	public Rodada novaRodada(String nomeJogador) throws JogadorNaoEncontradoException {
		Rodada rodada = this.rodadaFactory.getRodada(this.jogadorRepository.getPorNome(nomeJogador));
		salvarRodada(rodada);
		return rodada;
	}

	public boolean salvarRodada(Rodada rodada) {
		try {
			this.rodadaRepository.inserir(rodada);
			return true;
		} catch (RepositoryException e) {
			e.printStackTrace();
			return false;
		}
	}
}
