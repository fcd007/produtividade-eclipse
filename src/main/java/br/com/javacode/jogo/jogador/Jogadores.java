package br.com.javacode.jogo.jogador;

import br.com.javacode.jogo.br.com.java.jogo.jogoutil.Imprimir;
import br.com.javacode.jogo.br.com.java.jogo.taboleiro.Taboleiro;

public class Jogadores implements Imprimir {

	private Jogador[] jogadores;

	private int jogadorAtualIndex = -1;

	public Jogadores(Taboleiro board, int numeroDeJogadores) {
		jogadores = new Jogador[numeroDeJogadores];
		char nomeAtual = 'A';

		for (int i = 0; i < jogadores.length; i++) {
			jogadores[i] = new Jogador(String.valueOf(nomeAtual));
			nomeAtual++;
		}

		board.setUpJogadores(jogadores);
	}

	public Jogador next() {
		jogadorAtualIndex = (jogadorAtualIndex + 1) % jogadores.length;
		return jogadores[jogadorAtualIndex];
	}

	@Override
	public void print() {
		for (Jogador contador : jogadores) {
			System.out.format("Jogador '%s' está na posição '%s' \n", contador.getNome(), contador.getAtual());
		}
	}

}
