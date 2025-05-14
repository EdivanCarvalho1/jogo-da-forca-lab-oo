package br.iff.edu.bancodepalavras.dominio.palavra;

import java.util.Map;

import br.iff.edu.bancodepalavras.dominio.tema.Tema;
import br.iff.edu.bancodepalavras.dominio.tema.TemaRepository;
import br.iff.edu.repository.RepositoryException;

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
	
	public static void createSoleInstance(TemaRepository temaRepository, PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
		soleInstance = new PalavraAppService(temaRepository, palavraRepository, palavraFactory);
	}
	
	public static PalavraAppService getSoleInstance() {
		return soleInstance;
	}
	public boolean novaPalavra(String palavra, long idTema) {
	    try {
	        Tema tema = this.temaRepository.getPorId(1L);
	        
	        if (tema == null) {
	            throw new IllegalArgumentException("Tema com ID " + idTema + " não existe!");
	        }
	        
	        Map<Long, Palavra> mapPalavra = this.palavraRepository.getPorTema(tema);

	        for (Palavra p : mapPalavra.values()) {
	            if (p.comparar(palavra)) {
	                return true;
	            }
	        }

	        Palavra novaPalavra = this.palavraFactory.getPalavra(palavra, tema);

	        this.palavraRepository.inserir(novaPalavra);

	        return true;
	    } catch (RepositoryException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}
