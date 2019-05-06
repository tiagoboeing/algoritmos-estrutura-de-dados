package br.furb.trabalho1_semestres_anteriores.pilha;

public interface Pilha <T> {

	public void push(T info);

	public T pop();

	public T peek();

	public boolean estaVazia();

	public void liberar();

}
