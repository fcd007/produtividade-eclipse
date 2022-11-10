package br.com.javacode.jogo.escadaserpentes;

public class Jogo {

	private static final int NUMERO_SPACE = 30;
	private static final int NUMERO_DE_JOGADORES = 4;

	public void play() {

		Board board = new Board(NUMERO_SPACE);
		board.print();
		
		Contadores contadores = new Contadores(board, NUMERO_DE_JOGADORES);
		contadores.print();
	}
}
