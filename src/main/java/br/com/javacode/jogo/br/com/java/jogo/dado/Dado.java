package br.com.javacode.jogo.br.com.java.jogo.dado;

import java.util.Random;

public class Dado {

	private static final int NUMERO_LADOS_DADOS = 6;

	private static Dado instance;

	private Random random = new Random();

	private Dado() {

	}

	public static Dado get() {
		if (instance == null) {
			instance = new Dado();
		}

		return instance;
	}

	public int jogarDado() {
		return random.nextInt(NUMERO_LADOS_DADOS) + 1;
	}

}
