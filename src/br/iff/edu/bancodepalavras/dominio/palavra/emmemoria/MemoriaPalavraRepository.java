package br.iff.edu.bancodepalavras.dominio.palavra.emmemoria;

import java.util.HashMap;
import java.util.Map;

import br.iff.edu.bancodepalavras.dominio.palavra.Palavra;
import br.iff.edu.bancodepalavras.dominio.palavra.PalavraRepository;
import br.iff.edu.bancodepalavras.dominio.tema.Tema;
import br.iff.edu.repository.RepositoryException;

public class MemoriaPalavraRepository implements PalavraRepository {

	private static MemoriaPalavraRepository soleInstance;

	private Map<Long, Palavra> hashMap;

	private long id;

	private MemoriaPalavraRepository() {
		this.hashMap = new HashMap<Long, Palavra>();
	}

	public static MemoriaPalavraRepository getSoleInstance() {
		if (soleInstance != null) {
			return soleInstance;
		}
		return soleInstance = new MemoriaPalavraRepository();
	}

	@Override
	public long getProximoId() {
		return this.id++;
	}

	@Override
	public Palavra getPorId(long id) {
		return this.hashMap.get(id);
	}

	@Override
	public Map<Long, Palavra> getPorTema(Tema tema) {
		if(tema == null) {
			throw new IllegalArgumentException("Tema não pode ser nulo!");
		}
		
		Map<Long, Palavra> resultado = new HashMap<>();

		for (Palavra palavra : this.hashMap.values()) {
			if (palavra.getTema().getId() == tema.getId()) {
				resultado.put(palavra.getId(), palavra);
			}
		}

		return resultado;
	}

	@Override
	public Map<Long, Palavra> getTodas() {
		return this.hashMap;
	}

	@Override
	public void inserir(Palavra palavra) throws RepositoryException{
		if(palavra != null) {
			this.hashMap.put(this.getProximoId(), palavra);
		}
	}

	@Override
	public void atualizar(Palavra palavra) throws RepositoryException{
		if (hashMap.containsKey(palavra.getId()) && hashMap != null) {
			hashMap.put(palavra.getId(), palavra);
		}
		throw new RepositoryException("Não foi possível atualizar a palavra");
	}

	@Override
	public void remover(Palavra palavra)  throws RepositoryException{
		if(hashMap.isEmpty() || palavra == null) {
			throw new RepositoryException("A lista está vazia e/ou o palavra é nulo");
		}
		this.hashMap.remove(palavra.getId(), palavra);
	}

}
