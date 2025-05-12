package br.iff.edu.jogodaforca.dominio.jogador;

import br.iff.edu.factory.EntityFactory;
import br.iff.edu.repository.Repository;

public class JogadorFactoryImpl extends EntityFactory implements JogadorFactory {
	
	private static JogadorFactoryImpl soleInstance;
	
	private JogadorFactoryImpl(JogadorRepository repository) {
		super(repository);
	}
	
	public static void createSoleInstance(JogadorRepository repository) {
		if(soleInstance == null) {
			soleInstance = new JogadorFactoryImpl(repository);
		}
		throw new IllegalArgumentException("A instância já existe!");
	}
	
	public static JogadorFactoryImpl getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException("A instância ainda não foi criada");
		}
		return soleInstance;
	}
	
	private JogadorRepository getJogadorRepository() {
		return (JogadorRepository)this.getRepository();
	}
	
	public Jogador getJogador(String nome) {
		Jogador j = Jogador.criar(this.getJogadorRepository().getProximoId(), nome);
		return j;
	}
}
