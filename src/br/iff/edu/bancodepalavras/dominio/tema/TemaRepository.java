package br.iff.edu.bancodepalavras.dominio.tema;

import java.util.Map;

import br.iff.edu.repository.Repository;
import br.iff.edu.repository.RepositoryException;

public interface TemaRepository extends Repository {
	
	public Tema getPorId(Long id);
	public Tema getPorNome(String nome);
	public Map<Long, Tema> getTodos();
	public void inserir(Tema tema) throws RepositoryException;;
	public void atualizar(Tema tema) throws RepositoryException;;
	public void remover(Tema tema) throws RepositoryException;
}
