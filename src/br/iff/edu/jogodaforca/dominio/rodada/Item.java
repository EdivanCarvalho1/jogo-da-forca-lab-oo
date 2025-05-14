package br.iff.edu.jogodaforca.dominio.rodada;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.iff.edu.bancodepalavras.dominio.letra.Letra;
import br.iff.edu.bancodepalavras.dominio.letra.LetraFactory;
import br.iff.edu.bancodepalavras.dominio.palavra.Palavra;
import br.iff.edu.jogodaforca.dominio.ObjetoDominioImpl;

public class Item extends ObjetoDominioImpl {

	private List<Integer> posicoesDescobertas;
	private String palavraArriscada = null;
	private Palavra palavra;

	private Item(long id, Palavra palavra) {
		super(id);
		this.palavra = palavra;
		this.posicoesDescobertas = new ArrayList<>();
	}

	private Item(long id, Palavra palavra, List<Integer> posicoesDescobertas, String palavraArriscada) {
		super(id);
		this.palavra = palavra;
		this.posicoesDescobertas = posicoesDescobertas;
		this.palavraArriscada = palavraArriscada;
	}

	public static Item criar(long id, Palavra palavra) {
		return new Item(id, palavra);
	}

	public static Item reconstituir(long id, Palavra palavra, List<Integer> posicoesDescobertas, String palavraArriscada) {
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
	    Set<Integer> posicoesSet = new HashSet<>(this.posicoesDescobertas);
	    List<Letra> letrasEncobertas = new ArrayList<>();

	    for (int i = 0; i < todasAsLetras.length; i++) {
	        if (!posicoesSet.contains(i)) {
	            letrasEncobertas.add(letraFactory.getLetraEncoberta());
	        }
	    }

	    return letrasEncobertas.toArray(new Letra[0]);
	}

	public Letra[] getLetrasDescobertas() {
	    Letra[] todasAsLetras = this.palavra.getLetras();
	    Set<Integer> posicoesSet = new HashSet<>(this.posicoesDescobertas);
	    List<Letra> letrasDescobertas = new ArrayList<>();

	    for (int i = 0; i < todasAsLetras.length; i++) {
	        if (posicoesSet.contains(i)) {
	            letrasDescobertas.add(todasAsLetras[i]);
	        }
	    }

	    return letrasDescobertas.toArray(new Letra[0]);
	}

	public int qtdeLetrasEncobertas() {
	    Letra[] todasAsLetras = this.palavra.getLetras();
	    Set<Integer> posicoesSet = new HashSet<>(this.posicoesDescobertas);
	    int count = 0;

	    for (int i = 0; i < todasAsLetras.length; i++) {
	        if (!posicoesSet.contains(i)) {
	            count++;
	        }
	    }

	    return count;
	}

	public int getPontosLetrasDescobertas(int pontos) {
		return pontos * this.posicoesDescobertas.size();
	}

	public boolean descobriu() {
		return this.acertou() || this.qtdeLetrasEncobertas() == 0;
	}

	public void exibir() {
	    LetraFactory letraFactory = Palavra.getLetraFactory();
	    Letra[] todasAsLetras = this.palavra.getLetras();
	    Set<Integer> posicoesSet = new HashSet<>(this.posicoesDescobertas);

	    for (int i = 0; i < todasAsLetras.length; i++) {
	        if (posicoesSet.contains(i)) {
	            System.out.print(todasAsLetras[i].getCodigo());
	        } else {
	            System.out.print(letraFactory.getLetraEncoberta().getCodigo());
	        }
	    }
	    System.out.println();
	}

	protected boolean tentar(char codigo) {
		boolean encontrou = false;
		for (int i = 0; i < palavra.getLetras().length; i++) {
			if (codigo == this.palavra.getLetra(i).getCodigo()) {
				if (!this.posicoesDescobertas.contains(i)) {
					this.posicoesDescobertas.add(i);
				}
				encontrou = true;
			}
		}
		return encontrou;
	}

	public void arriscar(String palavra) {
		this.palavraArriscada = palavra;
	}

	public boolean acertou() {
	    return palavraArriscada != null && palavra.comparar(palavraArriscada);
	}

	public boolean arriscou() {
		return this.palavraArriscada != null;
	}
}
