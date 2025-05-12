package br.iff.edu.bancodepalavras.dominio.tema;

import br.iff.edu.factory.EntityFactory;
import br.iff.edu.repository.RepositoryException;

public class TemaFactoryImpl extends EntityFactory implements TemaFactory{
	
	private static TemaFactoryImpl soleInstance;
	
	private TemaFactoryImpl(TemaRepository repository) {
		super(repository);
	}
	
	public static void createSoleInstance(TemaRepository repository) {
		if(soleInstance == null) {
			soleInstance = new TemaFactoryImpl(repository);
		}
		throw new IllegalArgumentException("A instância já existe!");
	}
	
	public static TemaFactoryImpl getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException("A instância ainda não existe!");
		}
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
