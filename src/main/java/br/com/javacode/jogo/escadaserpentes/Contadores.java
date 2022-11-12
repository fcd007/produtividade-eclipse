package br.com.javacode.jogo.escadaserpentes;

public class Contadores implements Printable {

	private Contador[] contadores;

	private int jogadorAtualIndex = -1;

	public Contadores(Board board, int numeroDeJogadores) {
		contadores = new Contador[numeroDeJogadores];
		char nomeAtual = 'A';

		for (int i = 0; i < contadores.length; i++) {
			contadores[i] = new Contador(String.valueOf(nomeAtual));
			nomeAtual++;
		}

		board.setUpContadores(contadores);
	}

	public Contador next() {
		jogadorAtualIndex = (jogadorAtualIndex + 1) % contadores.length;
		return contadores[jogadorAtualIndex];
	}

	@Override
	public void print() {
		for (Contador contador : contadores) {
			System.out.format("Jogador '%s' está na posição '%s' \n", contador.getNome(), contador.getAtual());
		}
	}

}
