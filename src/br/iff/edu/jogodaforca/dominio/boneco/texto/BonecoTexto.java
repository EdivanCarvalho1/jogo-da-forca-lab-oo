package br.iff.edu.jogodaforca.dominio.boneco.texto;

import br.iff.edu.jogodaforca.dominio.boneco.Boneco;

public class BonecoTexto implements Boneco {

	private static BonecoTexto soleInstance;

	private String[] partes = { "cabeca", "olho esquerdo", "olho direito", "nariz", "boca", "tronco", "braço esquerdo",
			"braço direito", "perna esquerda", "perna direita" };

	private BonecoTexto() {

	}

	public static BonecoTexto getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BonecoTexto();
		}
		return soleInstance;
	}

	@Override
	public void exibir(Object context, int quantidadePartes) {
		System.out.println("Boneco (modo texto):");
		for (int i = 0; i < quantidadePartes && i < partes.length; i++) {
			System.out.println(" - " + partes[i]);
		}
	}
}
