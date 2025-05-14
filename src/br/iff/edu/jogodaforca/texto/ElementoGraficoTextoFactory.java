package br.iff.edu.jogodaforca.texto;

import br.iff.edu.bancodepalavras.dominio.letra.Letra;
import br.iff.edu.bancodepalavras.dominio.letra.texto.LetraTextoFactory;
import br.iff.edu.jogodaforca.ElementoGraficoFactory;
import br.iff.edu.jogodaforca.dominio.boneco.Boneco;
import br.iff.edu.jogodaforca.dominio.boneco.texto.BonecoTextoFactory;

public class ElementoGraficoTextoFactory implements ElementoGraficoFactory {
	
	private static ElementoGraficoTextoFactory soleInstance;
	
	private LetraTextoFactory letraTextoFactory;
	
	private BonecoTextoFactory bonecoTextoFactory;
	
	private ElementoGraficoTextoFactory() {
		this.letraTextoFactory = LetraTextoFactory.getSoleInstance();
		this.bonecoTextoFactory = BonecoTextoFactory.getSoleInstance();
	}

	public static ElementoGraficoTextoFactory getSoleInstance() {
		if (soleInstance != null) {
			return soleInstance;
		}
		return soleInstance = new ElementoGraficoTextoFactory();
	}
	
	public Letra getLetra(char codigo) {
		return letraTextoFactory.getLetra(codigo);
	}
	
	public Letra getLetraEncoberta() {
		return letraTextoFactory.getLetraEncoberta();
	}
	
	public Boneco getBoneco() {
		return bonecoTextoFactory.getBoneco();
	}
}
