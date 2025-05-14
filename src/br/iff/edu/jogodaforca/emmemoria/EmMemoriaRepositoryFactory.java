package br.iff.edu.jogodaforca.emmemoria;

import br.iff.edu.bancodepalavras.dominio.palavra.PalavraRepository;
import br.iff.edu.bancodepalavras.dominio.palavra.emmemoria.MemoriaPalavraRepository;
import br.iff.edu.bancodepalavras.dominio.tema.TemaRepository;
import br.iff.edu.bancodepalavras.dominio.tema.emmemoria.MemoriaTemaRepository;
import br.iff.edu.jogodaforca.RepositoryFactory;
import br.iff.edu.jogodaforca.dominio.jogador.JogadorRepository;
import br.iff.edu.jogodaforca.dominio.jogador.emmemoria.MemoriaJogadorRepository;
import br.iff.edu.jogodaforca.dominio.rodada.RodadaRepository;
import br.iff.edu.jogodaforca.dominio.rodada.emmemoria.MemoriaRodadaRepository;

public class EmMemoriaRepositoryFactory implements RepositoryFactory {
	
	private static EmMemoriaRepositoryFactory soleInstance;
	
	private EmMemoriaRepositoryFactory() {
	}
	
	public static EmMemoriaRepositoryFactory getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new EmMemoriaRepositoryFactory();
			return soleInstance;
		}
		return soleInstance;
	}
	
	@Override
	public PalavraRepository getPalavraRepository() {
		return MemoriaPalavraRepository.getSoleInstance();
	}

	@Override
	public TemaRepository getTemaRepository() {
		return MemoriaTemaRepository.getSoleInstance();
	}

	@Override
	public RodadaRepository getRodadaRepository() {
		return MemoriaRodadaRepository.getSoleInstance();
	}

	@Override
	public JogadorRepository getJogadorRepository() {
		return MemoriaJogadorRepository.getSoleInstance();
	}
}
