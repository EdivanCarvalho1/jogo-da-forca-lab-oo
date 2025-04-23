package br.iff.edu.bancodepalavras.dominio.tema;

import br.iff.edu.factory.EntityFactory;
import br.iff.edu.repository.RepositoryException;

public class TemaFactoryImpl extends EntityFactory implements TemaFactory{
	
	private static TemaFactoryImpl soleInstance;
	
	private TemaFactoryImpl(TemaRepository repository) {
		super(repository);
	}
	
	public static void createSoleInstance(TemaRepository repository) {
		soleInstance = new TemaFactoryImpl(repository);
	}
	
	public static TemaFactoryImpl getSoleInstance() {
		return soleInstance;
	}
	
	public TemaRepository getTemaRepository() {
		return (TemaRepository)getRepository();
	}

	@Override
	public Tema getTema(String nome) {
		
		Tema t = Tema.criar(getTemaRepository().getProximoId(), nome);
		return t;
	}
}
