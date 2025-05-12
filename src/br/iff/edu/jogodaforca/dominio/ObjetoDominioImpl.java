package br.iff.edu.jogodaforca.dominio;

public class ObjetoDominioImpl implements ObjetoDominio {
	
	private Long id;
	
	public ObjetoDominioImpl(Long id) {
		if(id != null) {
			this.id = id;
		}
		throw new IllegalArgumentException("O id não pode ser nulo");
	}
	
	@Override
	public Long getId() {
		return this.id;
	}
	
}
