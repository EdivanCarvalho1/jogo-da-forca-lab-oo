package br.iff.edu.bancodepalavras.dominio.letra;

public abstract class LetraFactoryImpl implements LetraFactory {
    
    private Letra encoberta;
    private final Letra[] pool;

    protected LetraFactoryImpl() {
        this.pool = new Letra[26];
    }

    @Override
    public final Letra getLetra(char codigo) {
        codigo = Character.toLowerCase(codigo);

        if (codigo < 'a' || codigo > 'z') {
            throw new IllegalArgumentException("O código deve estar entre 'a' e 'z'");
        }

        int i = codigo - 'a';

        if (pool[i] == null) {
            pool[i] = criarLetra(codigo);
        }

        return pool[i];
    }

    @Override
    public final Letra getLetraEncoberta() {
        if (encoberta == null) {
            encoberta = criarLetra('*');
        }
        return encoberta;
    }

    protected abstract Letra criarLetra(char codigo);
}