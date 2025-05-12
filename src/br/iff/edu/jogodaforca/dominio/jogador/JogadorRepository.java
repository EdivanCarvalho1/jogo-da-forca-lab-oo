package br.iff.edu.jogodaforca.dominio.jogador;

import br.iff.edu.repository.Repository;
import br.iff.edu.repository.RepositoryException;

public interface JogadorRepository extends Repository {
	
	public Jogador getPorId(long id);
	public Jogador getPorNome(String nome);
	public void inserir(Jogador jogador) throws RepositoryException;
	public void atualizar(Jogador jogador) throws RepositoryException;
	public void remover(Jogador jogador) throws RepositoryException;
}
