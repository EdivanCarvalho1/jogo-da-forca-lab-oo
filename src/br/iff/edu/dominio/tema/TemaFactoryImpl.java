package br.iff.edu.dominio.tema;

import br.iff.edu.factory.EntityFactory;

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
		return Tema.criar(getTemaRepository().getProximoId(), nome);
	}
}
