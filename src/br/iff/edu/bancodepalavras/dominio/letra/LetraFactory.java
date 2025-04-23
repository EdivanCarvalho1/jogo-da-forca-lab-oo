package br.iff.edu.bancodepalavras.dominio.letra;

public interface LetraFactory {
	
	public Letra getLetra(char codigo);
	
	public Letra getLetraEncoberta();
}
