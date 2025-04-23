package br.iff.edu.bancodepalavras.dominio.palavra;

import br.iff.edu.bancodepalavras.dominio.letra.Letra;
import br.iff.edu.bancodepalavras.dominio.letra.LetraFactory;
import br.iff.edu.bancodepalavras.dominio.tema.Tema;
import br.iff.edu.dominio.ObjetoDominioImpl;

public class Palavra extends ObjetoDominioImpl {
	
	private String palavra;
	
	private Tema tema;
	
	private Letra[] letras;
	
	private static LetraFactory letraFactory;
	
	private Palavra(Long id, String palavra, Tema tema) {
		super(id);
		this.palavra = palavra;
		this.tema = tema;
		
		for (int i = 0; i < palavra.length(); i++) {
			this.letras[i] = getLetraFactory().getLetra(palavra.charAt(i));
		}
	}
	
	public static void setLetraFactory(LetraFactory factory) {
		if(factory != null) {
			letraFactory = factory;
		}
		throw new IllegalArgumentException("LetraFactory não pode ser nulo!");
	}
	public static LetraFactory getLetraFactory() {
		if(letraFactory != null){
			return letraFactory;
		}
		throw new RuntimeException("LetraFactory é nulo!");
			
	}
	public static Palavra criar(long id, String palavra, Tema tema) {
		return new Palavra(id, palavra, tema);
	}
	public static Palavra reconstituir(long id, String palavra, Tema tema) {
		return new Palavra(id, palavra, tema);
	}
	public Letra[] getLetras() {
		return this.letras;
	}
	public Letra getLetra(int posicao) {
		return this.letras[posicao];
	}
	
	public void exibir() {
		System.out.println();
	}
	
	public int[] tentar(char codigo) {
	    int contador = 0;
	    for (int i = 0; i < this.palavra.length(); i++) {
	        if (this.palavra.charAt(i) == codigo) {
	            contador++;
	        }
	    }

	    if (contador == 0) {
	        return new int[0];
	    }
	    
	    int[] posicoes = new int[contador];
	    int indice = 0;
	    for (int i = 0; i < this.palavra.length(); i++) {
	        if (this.palavra.charAt(i) == codigo) {
	            posicoes[indice++] = i;
	        }
	    }

	    return posicoes;
	}
	
	public Tema getTema() {
		if(this.tema != null) {
			return this.tema;
		}
		throw new RuntimeException("O tema é nulo!");
	}
	
	public boolean comparar(String palavra) {

	    if (palavra.length() != this.getTamanho()) {
	        return false;  
	    }
	    
	    for (int i = 0; i < palavra.length(); i++) {
	        if (palavra.charAt(i) != this.palavra.charAt(i)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public int getTamanho() {
		return this.palavra.length();
	}
	
	@Override
	public String toString() {
	    return "Palavra{" +
	           "id=" + getId() +
	           ", palavra='" + palavra + '\'' +
	           ", tema=" + tema +
	           '}';
	}

	
}
