package br.iff.edu.bancodepalavras.dominio.palavra;

import br.iff.edu.bancodepalavras.dominio.tema.Tema;
import br.iff.edu.factory.EntityFactory;

public class PalavraFactoryImpl extends EntityFactory implements PalavraFactory {
	
	private static PalavraFactoryImpl soleInstance;
	
	private PalavraRepository palavraRepo;
	
	private PalavraFactoryImpl(PalavraRepository repo){
		super(repo);
	}
	
	public static void createSoleInstance(PalavraRepository palavraRepo) {
		if(soleInstance != null) {
			new PalavraFactoryImpl(palavraRepo);
		}
		throw new IllegalArgumentException("A instancia já existe!");
	}
	
	public static PalavraFactoryImpl getSoleInstance() {
		return soleInstance;
	}
	
	private PalavraRepository getPalavraRepository() {
		return this.palavraRepo;
	}


	@Override
	public Palavra getPalavra(String palavra, Tema tema) {
		Palavra p = Palavra.criar(this.getProximoId(), palavra, tema);
		return p;		
	}
}
