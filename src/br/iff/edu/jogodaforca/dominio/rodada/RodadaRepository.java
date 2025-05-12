package br.iff.edu.jogodaforca.dominio.rodada;

import java.util.Map;

import br.iff.edu.jogodaforca.dominio.jogador.Jogador;
import br.iff.edu.repository.Repository;
import br.iff.edu.repository.RepositoryException;

public interface RodadaRepository extends Repository {
	
	public Rodada getPorId(long id);
	public Map<Long, Rodada> getPorJogador(Jogador jogador);
	public void inserir(Rodada rodada) throws RepositoryException;
	public void atualizar(Rodada rodada) throws RepositoryException;
	public void remover(Rodada rodada) throws RepositoryException;
	
}
