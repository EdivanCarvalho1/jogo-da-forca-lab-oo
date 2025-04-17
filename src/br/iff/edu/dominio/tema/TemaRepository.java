package br.iff.edu.dominio.tema;

import java.util.Map;

import br.iff.edu.repository.Repository;

public interface TemaRepository extends Repository {
	
	public Tema getPorId(Long id);
	public Tema getPorNome(String nome);
	public Map<Long, Tema> getTodos();
	public void inserir(Tema tema);
	public void atualizar(Tema tema);
	public void remover(Tema tema);
}
