package br.com.javacode.jogo.br.com.java.jogo.taboleiro;

import java.util.Arrays;

import br.com.javacode.jogo.br.com.java.jogo.jogador.Jogador;
import br.com.javacode.jogo.br.com.java.jogo.jogoutil.Imprimir;
import br.com.javacode.jogo.br.com.java.jogo.taboleiro.Espaco.Type;

public class Taboleiro implements Imprimir {

	private Espaco[] spaces;

	private Espaco spaceHome;

	private Espaco spaceStartHere;

	private Jogador ganhador;

	public Taboleiro(int numeroSpacos) {
		spaces = new Espaco[numeroSpacos + 2];

		for (int index = 0; index < spaces.length; index++) {
			if (index == 0) {
				spaces[index] = new Espaco(0, Type.START_HERE);
				spaceStartHere = spaces[index];
			} else if (index == spaces.length - 1) {
				spaces[index] = new Espaco(index, Type.HOME);
				spaceHome = spaces[index];
			} else {
				spaces[index] = new Espaco(index, Type.REGULAR);
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

		for (Espaco space : spaces) {
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
		Espaco espaco = jogador.getAtual();
		int novaPosicao = espaco.getNumber() + numeroDado;

		Espaco novoSpaco;

		if (novaPosicao >= spaceHome.getNumber()) {
			novoSpaco = spaceHome;
			ganhador = jogador;
		} else {
			novoSpaco = spaces[novaPosicao];
		}

		jogador.goTo(novoSpaco);
		System.out.format("Jogador '%s' foi para a casa %s\n", jogador.getNome(), novaPosicao);

		Transicao transition = novoSpaco.getTransition();

		if (transition != null) {
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
		Espaco spaceOrigem = spaces[origem];
		Espaco spaceDestino = spaces[destino];

		Transicao transition = new Transicao(spaceOrigem, spaceDestino);
		spaceOrigem.setTransition(transition);
	}
}
