package br.com.javacode.jogo.br.com.java.jogo.jogador;

import br.com.javacode.jogo.br.com.java.jogo.dado.Dado;
import br.com.javacode.jogo.br.com.java.jogo.taboleiro.Espaco;
import br.com.javacode.jogo.br.com.java.jogo.taboleiro.Taboleiro;

public class Jogador {

	private String nome;

	private Espaco atual;

	public Jogador(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Espaco getAtual() {
		return atual;
	}

	public void goTo(Espaco spaceStartHere) {
		atual = spaceStartHere;
	}

	public void jogarDado(Taboleiro board) {
		Dado dado = Dado.get();
		int numeroDado = dado.jogarDado();

		System.out.format("Jogador '%s' jogou o dado e o resultado foi %d\n", nome, numeroDado);

		board.mover(this, numeroDado);
	}
}
