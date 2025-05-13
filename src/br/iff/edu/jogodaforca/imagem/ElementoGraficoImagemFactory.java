package br.iff.edu.jogodaforca.imagem;

import br.iff.edu.bancodepalavras.dominio.letra.Letra;
import br.iff.edu.jogodaforca.ElementoGraficoFactory;
import br.iff.edu.jogodaforca.dominio.boneco.Boneco;

public class ElementoGraficoImagemFactory implements ElementoGraficoFactory {
	
	private static ElementoGraficoImagemFactory soleInstance;
	
	private ElementoGraficoImagemFactory() {
	}

	public static ElementoGraficoImagemFactory getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new ElementoGraficoImagemFactory();
		}
		return soleInstance;
	}

	@Override
	public Boneco getBoneco() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Letra getLetra(char codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Letra getLetraEncoberta() {
		// TODO Auto-generated method stub
		return null;
	}
}
