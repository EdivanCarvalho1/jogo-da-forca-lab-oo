package br.iff.edu.jogodaforca;

import br.iff.edu.bancodepalavras.dominio.letra.LetraFactory;
import br.iff.edu.bancodepalavras.dominio.palavra.PalavraFactory;
import br.iff.edu.bancodepalavras.dominio.palavra.PalavraFactoryImpl;
import br.iff.edu.bancodepalavras.dominio.tema.TemaFactory;
import br.iff.edu.bancodepalavras.dominio.tema.TemaFactoryImpl;
import br.iff.edu.jogodaforca.dominio.boneco.BonecoFactory;
import br.iff.edu.jogodaforca.dominio.jogador.JogadorFactory;
import br.iff.edu.jogodaforca.dominio.jogador.JogadorFactoryImpl;
import br.iff.edu.jogodaforca.dominio.rodada.RodadaFactory;
import br.iff.edu.jogodaforca.dominio.rodada.RodadaSorteioFactory;
import br.iff.edu.jogodaforca.embdr.BDRRepositoryFactory;
import br.iff.edu.jogodaforca.emmemoria.EmMemoriaRepositoryFactory;
import br.iff.edu.jogodaforca.imagem.ElementoGraficoImagemFactory;
import br.iff.edu.jogodaforca.texto.ElementoGraficoTextoFactory;

public class Aplicacao {
	
	
	private static String[] TIPOS_REPOSITORY_FACTORY = {"memoria", "relacional"};
	private static String[] TIPOS_ELEMENTO_GRAFICO_FACTORY = {"texto", "imagem"};
	private static String[]TIPOS_RODADA_FACTORY = {"sorteio"};
	private static Aplicacao soleInstance;
	
	private String tipoRepositoryFactory = TIPOS_REPOSITORY_FACTORY[0];
	private String tipoElementoGraficoFactory = TIPOS_ELEMENTO_GRAFICO_FACTORY[0];
	private String tipoRodadaFactory = TIPOS_RODADA_FACTORY[0];
	
	private RodadaFactory rodadaFactory;
	
	private ElementoGraficoFactory elementoGraficoFactory;
	
	private RepositoryFactory repositoryFactory;
	
	private TemaFactory temaFactory;
	
	private PalavraFactory palavraFactory;
	
	private JogadorFactory jogadorFactory;
	
	private Aplicacao() {
		
	}
	
	public void configurar() {
		if (tipoElementoGraficoFactory.equals(TIPOS_ELEMENTO_GRAFICO_FACTORY[0])) {
			elementoGraficoFactory = ElementoGraficoTextoFactory.getSoleInstance();
		} else {
			elementoGraficoFactory = ElementoGraficoImagemFactory.getSoleInstance();
		}
		if (tipoRepositoryFactory.equals(TIPOS_REPOSITORY_FACTORY[0])) {
			repositoryFactory = EmMemoriaRepositoryFactory.getSoleInstance();
		} else {
			repositoryFactory = BDRRepositoryFactory.getSoleInstance();
		}
		
		if (tipoRodadaFactory.equals(TIPOS_RODADA_FACTORY[0])) {
			RodadaSorteioFactory.createSoleInstance(this.getRepositoryFactory().getRodadaRepository(),
					this.getRepositoryFactory().getTemaRepository(),
					this.getRepositoryFactory().getPalavraRepository());
			rodadaFactory = RodadaSorteioFactory.getSoleInstance();	
		}
	    
		TemaFactoryImpl.createSoleInstance(this.getRepositoryFactory().getTemaRepository());
		PalavraFactoryImpl.createSoleInstance(this.getRepositoryFactory().getPalavraRepository());
		JogadorFactoryImpl.createSoleInstance(this.getRepositoryFactory().getJogadorRepository());
		
	}
	
	public static Aplicacao getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new Aplicacao();
		}
		return soleInstance;
	}
	
	public String[] getTiposRepositoryFactory() {
		return TIPOS_REPOSITORY_FACTORY;
	}

	public void setTipoRepositoryFactory(String tipoRepositoryFactory) {
		this.tipoRepositoryFactory = tipoRepositoryFactory;
	}
	
	public RepositoryFactory getRepositoryFactory() {
		return this.repositoryFactory;
	}

	public String[] getTiposElementoGraficoFactory() {
		return TIPOS_ELEMENTO_GRAFICO_FACTORY;
	}

	public void setTipoElementoGraficoFactory(String tipoElementoGraficoFactory) {
		this.tipoElementoGraficoFactory = tipoElementoGraficoFactory;
	}

	private ElementoGraficoFactory getElementoGraficoFactory() {
		return elementoGraficoFactory;
	}

	public BonecoFactory getBonecoFactory() {
		return this.getElementoGraficoFactory();
	}

	public LetraFactory getLetraFactory() {
		return this.getElementoGraficoFactory();
	}

	public String[] getTiposRodadaFactory() {
		return TIPOS_RODADA_FACTORY;
	}
	public void setTipoRodadaFactory(String tipoRodadaFactory) {
		this.tipoRodadaFactory = tipoRodadaFactory;
	}

	public RodadaFactory getRodadaFactory() {
		
		return rodadaFactory;
	}
	
	public TemaFactory getTemaFactory() {
		temaFactory = TemaFactoryImpl.getSoleInstance();
		return temaFactory;
	}

	public PalavraFactory getPalavraFactory() {
		palavraFactory = PalavraFactoryImpl.getSoleInstance();
		return palavraFactory;
	}

	public JogadorFactory getJogadorFactory() {
		jogadorFactory = JogadorFactoryImpl.getSoleInstance();
		return jogadorFactory;
	}
}
