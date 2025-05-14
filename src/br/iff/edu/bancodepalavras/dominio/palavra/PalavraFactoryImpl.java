package br.iff.edu.bancodepalavras.dominio.palavra;

import br.iff.edu.bancodepalavras.dominio.tema.Tema;
import br.iff.edu.factory.EntityFactory;
import br.iff.edu.repository.RepositoryException;

public class PalavraFactoryImpl extends EntityFactory implements PalavraFactory {
	
	private static PalavraFactoryImpl soleInstance;
	
	
	private PalavraFactoryImpl(PalavraRepository repo){
		super(repo);
	}
	
	public static void createSoleInstance(PalavraRepository palavraRepo) {
		if(soleInstance != null) {
			throw new IllegalArgumentException("A instancia já existe!");
		}
		soleInstance = new PalavraFactoryImpl(palavraRepo);
	}
	
	public static PalavraFactoryImpl getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException("A instância ainda não foi criada!");
		}
		return soleInstance;
	}
	
	private PalavraRepository getPalavraRepository() {
		return (PalavraRepository)this.getRepository();
	}


	@Override
	public Palavra getPalavra(String palavra, Tema tema) {
		Palavra p = Palavra.criar(getPalavraRepository().getProximoId(), palavra, tema);
		return p;		
	}
}
