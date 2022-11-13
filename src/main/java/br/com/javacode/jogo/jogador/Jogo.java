package br.com.javacode.jogo.jogador;

import br.com.javacode.jogo.br.com.java.jogo.taboleiro.Taboleiro;

public class Jogo {

	private static final int NUMERO_SPACE = 30;
	private static final int NUMERO_DE_JOGADORES = 2;

	public void play() {
		Taboleiro board = new Taboleiro(NUMERO_SPACE);
		addTransition(board);
		board.print();

		Jogadores contadores = new Jogadores(board, NUMERO_DE_JOGADORES);
		contadores.print();

		while (!board.jogoRodando()) {
			Jogador contadorAtual = contadores.next();
			contadorAtual.jogarDado(board);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Jogador ganhador = board.getGanhador();
		System.out.format("O ganhador foi o jogador %s", ganhador.getNome());
	}

	private void addTransition(Taboleiro board) {
		//criando um recurso de regra de transicao
		board.adicionarTransicao(4, 12);
		board.adicionarTransicao(7, 9);
		board.adicionarTransicao(11, 25);
		board.adicionarTransicao(14, 2);
		board.adicionarTransicao(22, 5);
		board.adicionarTransicao(28, 18);
	}
}
