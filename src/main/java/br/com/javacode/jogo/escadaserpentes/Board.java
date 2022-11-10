package br.com.javacode.jogo.escadaserpentes;

import java.util.Arrays;

import br.com.javacode.jogo.escadaserpentes.Space.Type;

public class Board implements Printable {

	private Space[] spaces;

	private Space spaceHome;

	private Space spaceStartHere;

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

	public void setUpContadores(Contador[] contadores) {
		for (Contador contador : contadores) {
			contador.goTo(spaceStartHere);
		}

	}

}
