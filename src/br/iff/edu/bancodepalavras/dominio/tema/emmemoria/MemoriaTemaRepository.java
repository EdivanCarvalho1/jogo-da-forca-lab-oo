package br.iff.edu.bancodepalavras.dominio.tema.emmemoria;

import java.util.HashMap;
import java.util.Map;

import br.iff.edu.bancodepalavras.dominio.tema.Tema;
import br.iff.edu.bancodepalavras.dominio.tema.TemaRepository;
import br.iff.edu.repository.RepositoryException;

public class MemoriaTemaRepository implements TemaRepository {

	private static MemoriaTemaRepository soleInstance;

	private Map<Long, Tema> hashMap;

	private long id = 0;

	private MemoriaTemaRepository() {
		hashMap = new HashMap<Long, Tema>();
	}

	public static MemoriaTemaRepository getSoleInstance() {
		if (soleInstance == null) {
			return new MemoriaTemaRepository();
		}

		return soleInstance;
	}

	@Override
	public long getProximoId() {
		return id++;
	}

	@Override
	public Tema getPorId(Long id) {
		if(id == null) {
			throw new IllegalArgumentException("Id não pode ser nulo!");
		}
		return this.hashMap.get(id);
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
		if (tema == null) {
			throw new IllegalArgumentException("Tema não pode ser nulo!");
		}
		this.hashMap.put(tema.getId(), tema);
	}

	@Override
	public void atualizar(Tema tema) throws RepositoryException {
		if (hashMap.containsKey(tema.getId()) && hashMap != null) {
			hashMap.put(tema.getId(), tema);
		}
		throw new IllegalArgumentException("Tema não pode ser nulo!");
	}

	@Override
	public void remover(Tema tema) throws RepositoryException {
		if(hashMap.isEmpty() || tema == null) {
			throw new IllegalArgumentException("A lista está vazia e/ou o tema é nulo");
		}
		this.hashMap.remove(tema.getId(), tema);
	}

}
