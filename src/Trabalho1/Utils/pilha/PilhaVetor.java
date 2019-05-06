package Trabalho1.Utils.pilha;

import Trabalho1.Model.Pilha;

public class PilhaVetor<T> implements Pilha<T> {

	private T info[];
	private int limite;
	private int tamanho;

	public PilhaVetor(int limite) {
		info = (T[]) new Object[limite];

		this.limite = limite;
		this.tamanho = 0;

	}

	@Override
	public void push(T info) {
		if (tamanho == limite) {
			throw new PilhaCheiaException();
		} else {
			this.info[tamanho] = info;
			tamanho++;
		}
	}

	@Override
	public T pop() {
		if (estaVazia()) {
			throw new PilhaVaziaException();
		}
		T valor = info[tamanho - 1];
		info[tamanho - 1] = null;
		tamanho--;

		return valor;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("Pilha esta vazia");
		}
		return info[tamanho - 1];
	}

	@Override
	public boolean estaVazia() {
		return (tamanho == 0);
	}

	@Override
	public void liberar() {
		T valor;

		for (int i = 0; i < tamanho; i++) {
			info[i] = null;
		}
		tamanho = 0;

		while (!estaVazia()) {
			pop();
		}
	}

	@Override
	public String toString() {
		String resultado = "";

		for (int i = tamanho - 1; i >= 0; i--) {
			resultado += info[i];
			if (i > 0)
				resultado = resultado + ",";
		}
		return resultado;
	}

	public void concatenar(PilhaVetor<T> p) {
		for(int i=0; i<p.tamanho; i++){
			this.push(p.info[i]);
		}
	}
}
