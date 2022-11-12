package br.com.javacode.jogo.escadaserpentes;

public class Transition {

	public enum Type {
		COBRA, ESCADA;
	}

	private Space spaceInicial;

	private Space spaceDestino;

	private Type tipo;

	@SuppressWarnings("static-access")
	public Transition(Space spaceInicial, Space spaceDestino, Type tipo) {
		this.spaceInicial = spaceInicial;
		this.spaceDestino = spaceDestino;

		this.tipo = spaceInicial.getNumber() < spaceDestino.getNumber() ? tipo.ESCADA : tipo.COBRA;
	}

	public Space getSpaceInicial() {
		return spaceInicial;
	}

	public Space getSpaceDestino() {
		return spaceDestino;
	}

	public Type getTipo() {
		return tipo;
	}
}
