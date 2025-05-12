package br.iff.edu.jogodaforca.dominio.rodada.embdr;

import java.util.Map;

import br.iff.edu.jogodaforca.dominio.jogador.Jogador;
import br.iff.edu.jogodaforca.dominio.rodada.Rodada;
import br.iff.edu.jogodaforca.dominio.rodada.RodadaRepository;
import br.iff.edu.repository.RepositoryException;

public class BDRRodadaRepository implements RodadaRepository {

	@Override
	public Rodada getPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Long, Rodada> getPorJogador(Jogador jogador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Rodada rodada) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Rodada rodada) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Rodada rodada) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getProximoId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
