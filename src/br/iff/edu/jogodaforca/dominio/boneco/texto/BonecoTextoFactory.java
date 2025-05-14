package br.iff.edu.jogodaforca.dominio.boneco.texto;

import br.iff.edu.jogodaforca.dominio.boneco.Boneco;
import br.iff.edu.jogodaforca.dominio.boneco.BonecoFactory;

public class BonecoTextoFactory implements BonecoFactory{
	
	private static BonecoTextoFactory soleInstance;
	
	private BonecoTextoFactory() {
		
	}
	
	public static BonecoTextoFactory getSoleInstance() {
		if(soleInstance != null) {
			return soleInstance;
		}
		return soleInstance = new BonecoTextoFactory();
	}
	
	@Override
	public Boneco getBoneco() {
		return BonecoTexto.getSoleInstance();
	}

}
