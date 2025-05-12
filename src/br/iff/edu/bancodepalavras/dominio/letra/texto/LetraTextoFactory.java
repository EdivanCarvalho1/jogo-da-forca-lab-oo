package br.iff.edu.bancodepalavras.dominio.letra.texto;

import br.iff.edu.bancodepalavras.dominio.letra.Letra;
import br.iff.edu.bancodepalavras.dominio.letra.LetraFactoryImpl;

public class LetraTextoFactory extends LetraFactoryImpl{
	
	private static LetraTextoFactory soleInstance;
	
	private LetraTextoFactory() {
		super();
	}
	
	public static LetraTextoFactory getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new LetraTextoFactory();
		}
		return soleInstance;
	}
	
	@Override
	protected Letra criarLetra(char codigo) {
		return new LetraTexto(codigo);
		
	}

}
