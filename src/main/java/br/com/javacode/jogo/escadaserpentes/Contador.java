package br.com.javacode.jogo.escadaserpentes;

public class Contador {

	private String nome;

	private Space atual;

	public Contador(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Space getAtual() {
		return atual;
	}

	public void goTo(Space spaceStartHere) {
		atual = spaceStartHere;
	}

	public void jogarDado(Board board) {
		Dado dado = Dado.get();
		int numeroDado = dado.jogarDado();

		System.out.format("Jogado '%s' jogou o dado e o resultado foi '%d\n' ", nome, numeroDado);

		board.mover(this, numeroDado);
	}
}
