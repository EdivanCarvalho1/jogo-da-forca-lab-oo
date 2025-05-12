package br.iff.edu.jogodaforca.dominio.rodada.emmemoria;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import br.iff.edu.jogodaforca.dominio.jogador.Jogador;
import br.iff.edu.jogodaforca.dominio.rodada.Rodada;
import br.iff.edu.jogodaforca.dominio.rodada.RodadaRepository;
import br.iff.edu.repository.RepositoryException;

public class MemoriaRodadaRepository implements RodadaRepository {
	
	private static MemoriaRodadaRepository soleInstance;
	
	Map<Long, Rodada> memoriaRodada;
	
	private long id= 0;
	
	private MemoriaRodadaRepository() {
		this.memoriaRodada = new HashMap<Long, Rodada>();
	}
	
	public static MemoriaRodadaRepository getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new MemoriaRodadaRepository();
		}
		return soleInstance;
	}
	
	@Override
	public long getProximoId() {
		return this.id++;
	}

	@Override
	public Rodada getPorId(long id) {
		return this.memoriaRodada.get(id);
	}

	@Override
	public Map<Long, Rodada> getPorJogador(Jogador jogador) {
		return this.memoriaRodada.entrySet().stream().filter(entry -> entry.getValue().getJogador().equals(jogador))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	@Override
	public void inserir(Rodada rodada) throws RepositoryException {
		if(rodada != null) {
			this.memoriaRodada.put(rodada.getId(), rodada);
		}
		throw new RepositoryException("Rodada não pode ser nula!");
	}

	@Override
	public void atualizar(Rodada rodada) throws RepositoryException {
		if (rodada != null) {
			this.memoriaRodada.put(rodada.getId(), rodada);
		}
		throw new RepositoryException("Rodada não pode ser nula!");
	}

	@Override
	public void remover(Rodada rodada) throws RepositoryException {
		if(rodada != null) {
			this.memoriaRodada.remove(rodada.getId());
		}
	}
	
}
