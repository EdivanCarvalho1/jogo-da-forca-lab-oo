package br.iff.edu.bancodepalavras.dominio.palavra.emmemoria;

import java.util.Collections;
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
		if (soleInstance == null) {
			throw new RuntimeException("A instância de MemoriaPalavraRepository é nula!");
		}
		return soleInstance;
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

		for (Map.Entry<Long, Palavra> entry : hashMap.entrySet()) {
			Palavra palavra = entry.getValue();
			if (palavra.getTema().equals(tema)) {
				resultado.put(entry.getKey(), palavra);
			}
		}

		return resultado;
	}

	@Override
	public Map<Long, Palavra> getTodas() {
		return this.hashMap;
	}

	@Override
	public void inserir(Palavra palavra) throws RepositoryException {
		if(palavra != null) {
			this.hashMap.put(this.getProximoId(), palavra);
		}
	}

	@Override
	public void atualizar(Palavra palavra) throws RepositoryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Palavra palavra) throws RepositoryException {
		// TODO Auto-generated method stub

	}

}
