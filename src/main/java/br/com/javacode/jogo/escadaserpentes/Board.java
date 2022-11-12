package br.com.javacode.jogo.escadaserpentes;

import java.util.Arrays;

import br.com.javacode.jogo.escadaserpentes.Space.Type;

public class Board implements Printable {

	private Space[] spaces;

	private Space spaceHome;

	private Space spaceStartHere;

	private Jogador ganhador;

	public Board(int numeroSpacos) {
		spaces = new Space[numeroSpacos + 2];

		for (int index = 0; index < spaces.length; index++) {
			if (index == 0) {
				spaces[index] = new Space(0, Type.START_HERE);
				spaceStartHere = spaces[index];
			} else if (index == spaces.length - 1) {
				spaces[index] = new Space(index, Type.HOME);
				spaceHome = spaces[index];
			} else {
				spaces[index] = new Space(index, Type.REGULAR);
			}
		}
	}

	@Override
	public String toString() {
		return "Board [spaces=" + Arrays.toString(spaces) + "]";
	}

	@Override
	public void print() {
		System.out.println("TABULEIRO: ");

		for (Space space : spaces) {
			System.out.print(space + " ");
		}
		System.out.println();
	}

	public void setUpJogadores(Jogador[] contadores) {
		for (Jogador contador : contadores) {
			contador.goTo(spaceStartHere);
		}
	}

	public void mover(Jogador jogador, int numeroDado) {
		Space espaco = jogador.getAtual();
		int novaPosicao = espaco.getNumber() + numeroDado;

		Space novoSpaco;

		if (novaPosicao >= spaceHome.getNumber()) {
			novoSpaco = spaceHome;
			ganhador = jogador;
		} else {
			novoSpaco = spaces[novaPosicao];
		}

		jogador.goTo(novoSpaco);
		System.out.format("Jogador '%s' foi para a casa %s\n", jogador.getNome(), novaPosicao);
		
		Transition transition = novoSpaco.getTransition();
		
		if(transition != null) {
			System.out.format("Jogador '%s' achou uma %s %s\n", jogador.getNome(), transition.getTipo(), novoSpaco);
			jogador.goTo(transition.getSpaceInicial());
			System.out.format("Jogador '%s' foi para a casa %s\n", jogador.getNome(), transition.getSpaceDestino());
		}
	}

	public Boolean jogoRodando() {
		return ganhador != null;
	}
	
	public Jogador getGanhador() {
		return ganhador;
	}
	
	public void adicionarTransicao(int origem, int destino) {
		Space spaceOrigem = spaces[origem];
		Space spaceDestino = spaces[destino];
		
		Transition transition = new Transition(spaceOrigem, spaceDestino);		
		spaceOrigem.setTransition(transition);
	}
}
