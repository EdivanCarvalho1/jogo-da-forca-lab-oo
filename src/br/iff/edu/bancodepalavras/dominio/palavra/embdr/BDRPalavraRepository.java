package br.iff.edu.bancodepalavras.dominio.palavra.embdr;

import java.util.Map;

import br.iff.edu.bancodepalavras.dominio.palavra.Palavra;
import br.iff.edu.bancodepalavras.dominio.palavra.PalavraRepository;
import br.iff.edu.bancodepalavras.dominio.tema.Tema;
import br.iff.edu.repository.RepositoryException;

public class BDRPalavraRepository implements PalavraRepository {

	@Override
	public long getProximoId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Palavra getPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Long, Palavra> getPorTema(Tema tema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Long, Palavra> getTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Palavra palavra) throws RepositoryException {
		// TODO Auto-generated method stub
		
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
