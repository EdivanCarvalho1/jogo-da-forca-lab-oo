package br.iff.edu.dominio.letra;

public interface LetraFactory {
	
	public Letra getLetra(char codigo);
	
	public Letra getLetraEncoberta();
}
