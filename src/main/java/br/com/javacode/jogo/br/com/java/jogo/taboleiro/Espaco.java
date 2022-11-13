package br.com.javacode.jogo.br.com.java.jogo.taboleiro;

public class Espaco {

	public enum Type {
		START_HERE, HOME, REGULAR
	}

	private int number;
	private Type type;
	private Transicao transition;

	public Espaco(int number, Type type) {
		this.number = number;
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		if (type == Type.REGULAR) {
			return String.valueOf(number);
		} else {
			return number + " (" + type + ")";
		}
	}

	public Transicao getTransition() {
		return transition;
	}

	public void setTransition(Transicao transition) {
		this.transition = transition;
	}

}
