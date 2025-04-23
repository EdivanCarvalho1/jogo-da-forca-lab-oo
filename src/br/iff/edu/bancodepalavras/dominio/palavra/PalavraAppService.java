package br.iff.edu.bancodepalavras.dominio.palavra;

import br.iff.edu.bancodepalavras.dominio.tema.TemaRepository;

public class PalavraAppService {
	
	private static PalavraAppService soleInstance;
	
	private TemaRepository temaRepository;
	
	private PalavraRepository palavraRepository;
	
	private PalavraFactory palavraFactory;
	
	private PalavraAppService(TemaRepository temaRepository, PalavraRepository palavraRepository, PalavraFactory palavraFactory){
		this.setTemaRepository(temaRepository);
		this.setPalavraRepository(palavraRepository);
		this.setPalavraFactory(palavraFactory);
	}
	
	private final void setTemaRepository(TemaRepository temaRepository) {
		if(temaRepository == null) {
			throw new IllegalArgumentException("TemaRepository não pode ser nulo!");
		}
		this.temaRepository = temaRepository;
	}
	
	private final void setPalavraRepository(PalavraRepository palavraRepository) {
		if(palavraRepository == null) {
			throw new IllegalArgumentException("PalavraRepository não pode ser nulo!");
		}
		this.palavraRepository = palavraRepository;
	}
	private final void setPalavraFactory(PalavraFactory palavraFactory) {
		if(palavraRepository == null) {
			throw new IllegalArgumentException("PalavraFactory não pode ser nulo!");
		}
		this.palavraFactory = palavraFactory;
	}
}
