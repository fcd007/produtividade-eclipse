package br.com.javacode.jogo.br.com.java.jogo.taboleiro;

public class Transicao {

	public enum Type {
		COBRA, ESCADA;
	}

	private Espaco spaceInicial;

	private Espaco spaceDestino;

	private Type tipo;

	@SuppressWarnings("static-access")
	public Transicao(Espaco spaceInicial, Espaco spaceDestino) {
		this.spaceInicial = spaceInicial;
		this.spaceDestino = spaceDestino;

		this.tipo = spaceInicial.getNumber() < spaceDestino.getNumber() ? tipo.ESCADA : tipo.COBRA;
	}

	public Espaco getSpaceInicial() {
		return spaceInicial;
	}

	public Espaco getSpaceDestino() {
		return spaceDestino;
	}

	public Type getTipo() {
		return tipo;
	}
}
