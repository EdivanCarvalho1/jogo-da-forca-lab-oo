package br.iff.edu.bancodepalavras.dominio.letra;

import java.util.Objects;

import br.iff.edu.jogodaforca.dominio.ObjetoDominioImpl;

public abstract class Letra {
	
	private char codigo;
	
	protected Letra(char codigo) {

		this.codigo = codigo;
	}
	
	public char getCodigo() {
		return this.codigo;
	}
	
	public abstract void exibir(Object context);

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letra other = (Letra) obj;
		return codigo == other.codigo;
	}
	
	public final String toString() {
		return String.valueOf(codigo);
	}
}
