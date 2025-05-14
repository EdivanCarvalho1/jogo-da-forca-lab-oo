package br.iff.edu.jogodaforca.dominio.rodada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.iff.edu.bancodepalavras.dominio.letra.Letra;
import br.iff.edu.bancodepalavras.dominio.palavra.Palavra;
import br.iff.edu.bancodepalavras.dominio.tema.Tema;
import br.iff.edu.jogodaforca.dominio.ObjetoDominioImpl;
import br.iff.edu.jogodaforca.dominio.boneco.Boneco;
import br.iff.edu.jogodaforca.dominio.boneco.BonecoFactory;
import br.iff.edu.jogodaforca.dominio.jogador.Jogador;
import br.iff.edu.jogodaforca.texto.ElementoGraficoTextoFactory;

public class Rodada extends ObjetoDominioImpl {

	private static int maxPalavras = 3;
	private static int maxErros = 2;
	private static int pontosQuandoDescobreLetra = 15;
	private static int pontosQuandoDescobreTodas = 100;

	private Item[] itens;
	private Jogador jogador;
	private Letra[] erradas;
	private static Boneco boneco;
	private static BonecoFactory bonecoFactory;
	private boolean arriscou;
	private Tema tema;

	private Rodada(long id, Palavra[] palavras, Jogador jogador) {
		super(id);
		this.tema = palavras[0].getTema();
		for (Palavra p : palavras) {
			if (!p.getTema().equals(this.tema)) {
				throw new IllegalArgumentException("Todas as palavras devem ser do mesmo tema");
			}
		}
		this.jogador = jogador;
		this.erradas = new Letra[0];
		this.arriscou = false;
		this.itens = new Item[palavras.length];
		for (int i = 0; i < palavras.length; i++) {
			this.itens[i] = Item.criar(i, palavras[i]);
		}
	}

	private Rodada(long id, Item[] itens, Letra[] erradas, Jogador jogador) {
		super(id);
		this.itens = itens;
		this.erradas = erradas;
		this.jogador = jogador;
		this.arriscou = false;
		this.tema = itens[0].getPalavra().getTema();
	}

	public static Rodada criar(long id, Palavra[] palavras, Jogador jogador) {
		boneco = bonecoFactory.getBoneco();
		if (boneco == null) {
			throw new RuntimeException("BonecoFactory precisa ser settado!");
		}
		return new Rodada(id, palavras, jogador);
	}

	public static Rodada reconstituir(long id, Item[] itens, Letra[] erradas, Jogador jogador) {
		if (boneco != null) {
			return new Rodada(id, itens, erradas, jogador);
		}

		throw new RuntimeException("BonecoFactory precisa ser settado!");
	}
	
	public static int getMaxPalavras() {
		return maxPalavras;
	}

	public static void setMaxPalavras(int max) {
		maxPalavras = max;
	}

	public static int getMaxErros() {
		return maxErros;
	}

	public void setMaxErros(int max) {
		maxErros = max;
	}

	public static int getPontosQuandoDescobreLetra() {
		return pontosQuandoDescobreLetra;
	}

	public static void setPontosQuandoDescobreLetra(int pontos) {
		pontosQuandoDescobreLetra = pontos;
	}

	public static int getPontosQuandoDescobreTodas() {
		return pontosQuandoDescobreTodas;
	}

	public static void setPontosQuandoDescobreTodas(int pontos) {
		pontosQuandoDescobreTodas = pontos;
	}

	public static BonecoFactory getBonecoFactory() {
		return bonecoFactory;
	}

	public static void setBonecoFactory(BonecoFactory boneco) {
		bonecoFactory = boneco;
	}

	public Jogador getJogador() {
		return this.jogador;
	}
	public Tema getTema() {
		return this.tema;
	}
	public Palavra[] getPalavras() {
		
		List<Palavra> listPalavras = new ArrayList<>(); 
		for(int i =0; i < itens.length; i++){
			listPalavras.add(itens[i].getPalavra());
		}
		
		return listPalavras.toArray(new Palavra[0]);
	}
	public int getNumPalavras() {
		int count = 0;
		
		for(int i = 0; i < itens.length;i++) {
			if(itens[i].getPalavra() != null) {
				count++;
			}
		}
		return count;
	}
	public void tentar(char codigo) {
	    boolean acertou = false;

	    for (Item item : itens) {
	        if (item.tentar(codigo)) {
	            System.out.println("Você descobriu a letra: " + codigo);
	            acertou = true;
	        }
	    }

	    if (!acertou) {
	        Letra letraErrada = Palavra.getLetraFactory().getLetra(codigo);
	        
	        List<Letra> listaErradas = new ArrayList<>(Arrays.asList(erradas));
	        
	        boolean jaExiste = listaErradas.stream()
	            .anyMatch(l -> l.getCodigo() == letraErrada.getCodigo());

	        if (!jaExiste) {
	            listaErradas.add(letraErrada);
	            erradas = listaErradas.toArray(new Letra[0]);
	        }

	        System.out.println("Você errou!");
	    }
	}
	
	public Item[] getItens() {
		return itens;
	}

	public boolean arriscou() {
		return arriscou;
	}
	public boolean descobriu() {
		for(Item item: itens) {
			if(!item.descobriu()) {
				return false;
			}
		}
		return true;
	}
	public boolean encerrou() {
		return arriscou() || descobriu() ||	getQtdeTentativasRestantes() == 0;
	}
	public int calcularPontos() {
		int pontos = 0;
		for (Item item : itens) {
			pontos += item.getPontosLetrasDescobertas(pontosQuandoDescobreLetra);
		}
		if (descobriu()) {
			pontos += pontosQuandoDescobreTodas;
		}
		return pontos;
	}
	public void exibirItens() {
		for(Item item : itens) {
			item.exibir();
		}
	}
	public void exibirBoneco(Object context) {
		boneco.exibir(context, this.getQtdeErros());
	}
	public void exibirPalavras() {
		for(Item item : this.itens) {
			item.exibir();
		}
	}
	public void exibirLetrasErradas() {
		System.out.print("Letras erradas: ");
		for(Letra l: erradas) {
			System.out.print(l.getCodigo() + ", ");
		}
		System.out.println();
	}
	public Letra[] getTentativas() {
	    List<Letra> tentativas = new ArrayList<>(Arrays.asList(getErradas()));
	    
	    for (Letra l : getCertas()) {
	        if (!tentativas.contains(l)) {
	            tentativas.add(l);
	        }
	    }

	    return tentativas.toArray(new Letra[0]);
	}

	public Letra[] getCertas() {
	    List<Letra> certas = new ArrayList<>();
	    
	    for (Item item : itens) {
	        for (Letra l : item.getLetrasDescobertas()) {
	            if (!certas.contains(l)) {
	                certas.add(l);
	            }
	        }
	    }
	    
	    return certas.toArray(new Letra[0]);
	}

	public Letra[] getErradas() {
		return this.erradas;
	}
	
	public int getQtdeTentativasRestantes() {
		return maxErros - getQtdeErros();
	}
	public int getQtdeErros() {
		return this.getErradas().length;
	}
	public int getQtdeAcertos() {
		return this.getCertas().length;
	}
	public int getQtdeTentativas() {
		return this.getTentativas().length;
	}
	
}
