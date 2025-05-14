package br.iff.edu.jogodaforca.dominio;

public class ObjetoDominioImpl implements ObjetoDominio {
	
	private Long id;
	
	public ObjetoDominioImpl(Long id) {
		if(id == null) {
			throw new IllegalArgumentException("O id não pode ser nulo");
		}
		this.id = id;
		
	}
	
	@Override
	public Long getId() {
		return this.id;
	}
	
}
