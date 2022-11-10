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
}
