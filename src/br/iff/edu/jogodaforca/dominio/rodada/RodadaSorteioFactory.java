package br.iff.edu.jogodaforca.dominio.rodada;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import br.iff.edu.bancodepalavras.dominio.palavra.Palavra;
import br.iff.edu.bancodepalavras.dominio.palavra.PalavraRepository;
import br.iff.edu.bancodepalavras.dominio.tema.Tema;
import br.iff.edu.bancodepalavras.dominio.tema.TemaRepository;
import br.iff.edu.jogodaforca.dominio.jogador.Jogador;

public class RodadaSorteioFactory extends RodadaFactoryImpl implements RodadaFactory {
	
	private static RodadaSorteioFactory soleInstance;
	
	private RodadaSorteioFactory(RodadaRepository rodadaRepository, TemaRepository temaRepository,
			PalavraRepository palavraRepository) {
		super(rodadaRepository, temaRepository, palavraRepository);
	}
	
	public static void createSoleInstance(RodadaRepository rodadaRepository, TemaRepository temaRepository,
			PalavraRepository palavraRepository) {
			soleInstance = new RodadaSorteioFactory(rodadaRepository, temaRepository, palavraRepository);
		
	}

	public static RodadaSorteioFactory getSoleInstance() {
		if (soleInstance == null) {
			throw new IllegalStateException("Sole instance not created");
		}
		return soleInstance;
	}

	@Override
	public Rodada getRodada(Jogador jogador) {

	    Map<Long, Tema> mapaTemas = getTemaRepository().getTodos();
	    if (mapaTemas.isEmpty()) {
	        throw new IllegalStateException("Nenhum tema disponível");
	    }
	    List<Tema> temas = new ArrayList<>(mapaTemas.values());
	    int indice = new Random().nextInt(temas.size());
	    Tema temaSorteado = temas.get(indice);

	    Map<Long, Palavra> mapaPalavras = getPalavraRepository().getPorTema(temaSorteado);
	    List<Palavra> palavrasDoTema = new ArrayList<>(mapaPalavras.values());
	    
	    for(Palavra palavra : palavrasDoTema) {
	    	System.out.println(palavra.getLetra(0));
	    }

	    if (palavrasDoTema.size() < Rodada.getMaxPalavras()) {
	        throw new IllegalStateException("Tema sorteado não tem palavras suficientes");
	    }

	    Collections.shuffle(palavrasDoTema);
	    Palavra[] palavrasSorteadas = palavrasDoTema
	        .subList(0, Rodada.getMaxPalavras())
	        .toArray(new Palavra[0]);

	    long novaId = System.currentTimeMillis();
	    return Rodada.criar(novaId, palavrasSorteadas, jogador);
	}


}
