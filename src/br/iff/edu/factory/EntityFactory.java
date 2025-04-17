package br.iff.edu.factory;

import br.iff.edu.repository.Repository;

public abstract class EntityFactory {
	
	protected Repository repository;
	
	protected EntityFactory(Repository repository) {
		this.setRepository(repository);
	}
	
	private void setRepository(Repository repository) {
		if(repository != null) {
			this.repository = repository;
		}
		throw new IllegalArgumentException("Repository não pode ser nulo!");
	}
	protected Repository getRepository() {
		return this.repository;
	}
	protected Long getProximoId() {
		return this.repository.getProximoId();
	}
}
