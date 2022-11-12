package br.com.javacode.jogo.escadaserpentes;

public class Jogo {

	private static final int NUMERO_SPACE = 30;
	private static final int NUMERO_DE_JOGADORES = 2;

	public void play() {
		Board board = new Board(NUMERO_SPACE);
		board.print();

		Contadores contadores = new Contadores(board, NUMERO_DE_JOGADORES);
		contadores.print();

		while (true) {
			Contador contadorAtual = contadores.next();
			contadorAtual.jogarDado(board);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
