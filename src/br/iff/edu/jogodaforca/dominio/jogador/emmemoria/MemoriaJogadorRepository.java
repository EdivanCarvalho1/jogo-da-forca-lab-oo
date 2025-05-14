package br.iff.edu.jogodaforca.dominio.jogador.emmemoria;

import java.util.HashMap;
import java.util.Map;

import br.iff.edu.jogodaforca.dominio.jogador.Jogador;
import br.iff.edu.jogodaforca.dominio.jogador.JogadorRepository;
import br.iff.edu.repository.RepositoryException;

public class MemoriaJogadorRepository implements JogadorRepository{
	
	private static MemoriaJogadorRepository soleInstance;
	
	private long id = 0;
	
	private Map<Long, Jogador> hashMap;
	
	private MemoriaJogadorRepository() {
		this.hashMap = new HashMap<Long,Jogador>();
	}
	
	public static MemoriaJogadorRepository getSoleInstance() {
		if(soleInstance == null) {
			return soleInstance = new MemoriaJogadorRepository();
		}
		return soleInstance;
	}
	
	@Override
	public long getProximoId() {
		return this.id +=1;
	}

	@Override
	public Jogador getPorId(long id) {
		if(this.hashMap.isEmpty()) {
			throw new RuntimeException("A lista está vazia!");
		}
		
		if(id <= 0) {
			throw new IllegalArgumentException("O id não pode ser nulo!");
		}
		
		return hashMap.get(id);
	}

	@Override
	public Jogador getPorNome(String nome) {
	    if (nome == null || nome.trim().isEmpty()) {
	        throw new IllegalArgumentException("Nome não pode ser nulo ou vazio!");
	    }

	    return this.hashMap.values().stream()
	        .filter(j -> j.getNome().equals(nome))
	        .findFirst()
	        .orElseThrow(() -> new RuntimeException("O nome '" + nome + "' não existe na coleção"));
	}


	@Override
	public void inserir(Jogador jogador) throws RepositoryException {
		this.hashMap.put(this.getProximoId(), jogador);
	}

	@Override
	public void atualizar(Jogador jogador) throws RepositoryException {
		if (hashMap.containsKey(jogador.getId()) && hashMap != null) {
			hashMap.put(jogador.getId(), jogador);
		}
		throw new RepositoryException("Jogador não pode ser nulo!");
	}

	@Override
	public void remover(Jogador jogador) throws RepositoryException {
		if(hashMap.isEmpty() || jogador == null) {
			throw new RepositoryException("A lista está vazia e/ou o jogador é nulo");
		}
		this.hashMap.remove(jogador.getId(), jogador);
	}

}
