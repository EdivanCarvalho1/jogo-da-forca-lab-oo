package br.iff.edu.dominio.letra;

import br.iff.edu.factory.EntityFactory;
import br.iff.edu.repository.Repository;

public class LetraFactoryImpl extends EntityFactory implements LetraFactory {
	
	private Letra encoberta;
	private Letra[] pool;
	
	protected LetraFactoryImpl(Repository repository) {
		super(repository);
		this.pool = new Letra[26];
	}

	@Override
	public final Letra getLetra(char codigo) {
		if(codigo < 'a' || codigo > 'z') {
			throw new IllegalArgumentException("O código deve estar entre A e Z");
		}
		
		int i = codigo - 'a';
		
		Letra result = this.pool[i];
		if(result == null) {
			
		}
	}

	@Override
	public final Letra getLetraEncoberta() {
		return null;
	}
	
}
