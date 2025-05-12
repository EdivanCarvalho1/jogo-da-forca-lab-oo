package br.iff.edu.jogodaforca.dominio.rodada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.iff.edu.bancodepalavras.dominio.letra.Letra;
import br.iff.edu.bancodepalavras.dominio.letra.LetraFactory;
import br.iff.edu.bancodepalavras.dominio.palavra.Palavra;
import br.iff.edu.jogodaforca.dominio.ObjetoDominioImpl;

public class Item extends ObjetoDominioImpl {

	private int[] posicoesDescobertas;
	private String palavraArriscada = null;
	private Palavra palavra;

	private Item(long id, Palavra palavra) {
		super(id);
		this.palavra = palavra;
		this.posicoesDescobertas = new int[palavra.getTamanho()];
	}

	private Item(long id, Palavra palavra, int[] posicoesDescobertas, String palavraArriscada) {
		super(id);
		this.palavra = palavra;
		this.posicoesDescobertas = posicoesDescobertas;
		this.palavraArriscada = palavraArriscada;
	}

	public static Item criar(long id, Palavra palavra) {
		return new Item(id, palavra);
	}

	public static Item reconstituir(long id, Palavra palavra, int[] posicoesDescobertas, String palavraArriscada) {
		return new Item(id, palavra, posicoesDescobertas, palavraArriscada);
	}

	public Palavra getPalavra() {
		if (this.palavra != null) {
			return this.palavra;
		}
		throw new RuntimeException("A palavra está nula");
	}

	public Letra[] getLetrasEncobertas() {
		
	    LetraFactory letraFactory = Palavra.getLetraFactory();
	    
	    Letra[] todasAsLetras = this.palavra.getLetras();
	    
	    Set<Integer> posicoesDescobertasSet = Arrays.stream(posicoesDescobertas).boxed().collect(Collectors.toSet());

	    List<Letra> letrasDescobertas = new ArrayList<>();

	    for (int i = 0; i < todasAsLetras.length; i++) {
	        if (!posicoesDescobertasSet.contains(i)) {
	            letrasDescobertas.add(letraFactory.getLetraEncoberta());
	        }
	    }

	    return letrasDescobertas.toArray(new Letra[0]);
	}
	
	public Letra[] getLetrasDescobertas() {
		
	    LetraFactory letraFactory = Palavra.getLetraFactory();
	    
	    Letra[] todasAsLetras = this.palavra.getLetras();
	    
	    Set<Integer> posicoesDescobertasSet = Arrays.stream(posicoesDescobertas).boxed().collect(Collectors.toSet());

	    List<Letra> letrasDescobertas = new ArrayList<>();

	    for (int i = 0; i < todasAsLetras.length; i++) {
	        if (posicoesDescobertasSet.contains(i)) {
	            letrasDescobertas.add(todasAsLetras[i]);
	        }
	    }

	    return letrasDescobertas.toArray(new Letra[0]);
	}
	
	public int qtdeLetrasEncobertas() {
		
		int count = 0;
	    
	    Letra[] todasAsLetras = this.palavra.getLetras();
	    
	    Set<Integer> posicoesDescobertasSet = Arrays.stream(posicoesDescobertas).boxed().collect(Collectors.toSet());

	    for (int i = 0; i < todasAsLetras.length; i++) {
	        if (!posicoesDescobertasSet.contains(i)) {
	            count++;
	        }
	    }
	    
	    return count;

	}
	
	public int getPontosLetrasDescobertas(int pontos) {
		return pontos * this.qtdeLetrasEncobertas() - this.posicoesDescobertas.length;
	}
	
	public boolean descobriu() {
		return this.acertou() || this.qtdeLetrasEncobertas() == 0;
	}

	public void exibir(Object context) {
	    LetraFactory letraFactory = Palavra.getLetraFactory();
	    Letra[] todasAsLetras = this.palavra.getLetras();
	    Set<Integer> posicoesDescobertasSet = Arrays.stream(posicoesDescobertas)
	                                                 .boxed()
	                                                 .collect(Collectors.toSet());

	    for (int i = 0; i < todasAsLetras.length; i++) {
	        if (posicoesDescobertasSet.contains(i)) {
	            System.out.print(todasAsLetras[i].getCodigo());
	        } else {
	            System.out.print(letraFactory.getLetraEncoberta().getCodigo());
	        }
	    }
	    System.out.println();
	}

	protected boolean tentar(char codigo) {
		for(int i = 0; i < palavra.getLetras().length; i++) {
			if(codigo == this.palavra.getLetra(i).getCodigo()) {
				this.posicoesDescobertas[i] = i;
				return true;
			}
		}
		return false;
	}
	
	public void arriscar(String palavra) {
		this.palavraArriscada = palavra;
	}
	
	public boolean acertou() {
		return palavra.comparar(palavraArriscada);
	}
	
	public boolean arriscou() {
		return this.palavraArriscada != null;
	}
	
}
