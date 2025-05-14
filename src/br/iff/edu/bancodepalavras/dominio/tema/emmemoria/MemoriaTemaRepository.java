package br.iff.edu.bancodepalavras.dominio.tema.emmemoria;

import java.util.HashMap;
import java.util.Map;

import br.iff.edu.bancodepalavras.dominio.tema.Tema;
import br.iff.edu.bancodepalavras.dominio.tema.TemaRepository;
import br.iff.edu.repository.RepositoryException;

public class MemoriaTemaRepository implements TemaRepository {

	private static MemoriaTemaRepository soleInstance;

	private Map<Long, Tema> hashMap;

	private Long id = 0L;

	private MemoriaTemaRepository() {
		hashMap = new HashMap<Long, Tema>();
	}

	public static MemoriaTemaRepository getSoleInstance() {
		if (soleInstance != null) {
			return soleInstance;
		}

		return soleInstance = new MemoriaTemaRepository();
	}

	@Override
	public long getProximoId() {
		return id +=1L;
	}

	@Override
	public Tema getPorId(long id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Id não pode ser nulo!");
		}
		if(this.hashMap.isEmpty()) {
			throw new RuntimeException("A lista está vazia");
		}
		return this.hashMap.get(1);
	}

	@Override
	public Tema getPorNome(String nome) {
		
		if(nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome não pode ser nulo!");
		}
		
		return this.hashMap.values().stream()
		        .filter(t -> t.getNome().equalsIgnoreCase(nome))
		        .findFirst()
		        .orElse(null);
	}
	@Override
	public Map<Long, Tema> getTodos() {
		if (!hashMap.isEmpty()) {
			return this.hashMap;
		}
		throw new RuntimeException("O vetor está vazio!");
	}

	@Override
	public void inserir(Tema tema) throws RepositoryException {
		this.hashMap.put(this.getProximoId(), tema);
	}

	@Override
	public void atualizar(Tema tema) throws RepositoryException {
		if (hashMap.containsKey(tema.getId()) && hashMap != null) {
			hashMap.put(this.getProximoId(), tema);
		}
		throw new RepositoryException("Tema não pode ser nulo!");
	}

	@Override
	public void remover(Tema tema) throws RepositoryException {
		if(hashMap.isEmpty() || tema == null) {
			throw new RepositoryException("A lista está vazia e/ou o tema é nulo");
		}
		this.hashMap.remove(tema.getId(), tema);
	}

}
