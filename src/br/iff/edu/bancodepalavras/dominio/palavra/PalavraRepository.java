package br.iff.edu.bancodepalavras.dominio.palavra;

import java.util.Map;

import br.iff.edu.bancodepalavras.dominio.tema.Tema;
import br.iff.edu.repository.Repository;
import br.iff.edu.repository.RepositoryException;

public interface PalavraRepository extends Repository{

	public Palavra getPorId(long id);
	public Map<Long, Palavra> getPorTema(Tema tema);
	public Map<Long, Palavra> getTodas();
	public void inserir(Palavra palavra) throws RepositoryException;
	public void atualizar(Palavra palavra) throws RepositoryException;
	public void remover(Palavra palavra) throws RepositoryException;

}
