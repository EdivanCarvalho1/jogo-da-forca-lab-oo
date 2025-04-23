package br.iff.edu.bancodepalavras.dominio.letra;

import java.util.Objects;

import br.iff.edu.dominio.ObjetoDominioImpl;

public abstract class Letra extends ObjetoDominioImpl {
	
	private char codigo;
	
	protected Letra(long id, char codigo) {
		super(id);
		this.codigo = codigo;
	}
	
	public char getCodigo() {
		return this.codigo;
	}
	
	public void exibir(Object context) {
		
	}

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
