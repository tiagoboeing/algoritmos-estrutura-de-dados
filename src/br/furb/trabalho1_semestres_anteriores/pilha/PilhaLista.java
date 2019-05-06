package br.furb.trabalho1_semestres_anteriores.pilha;

import br.furb.trabalho1_semestres_anteriores.lista.Lista;
import br.furb.trabalho1_semestres_anteriores.lista.NoLista;


public class PilhaLista<T> implements Pilha<T> {

	private Lista<T> lista;

	public PilhaLista() {
		lista = new Lista();

	}

	@Override
	public void push(T info) {
		lista.inserir(info);

	}

	@Override
	public T pop() {
		if (estaVazia())
			throw new PilhaVaziaException();

		T valor;
		valor = lista.getPrimeiro().getInfo();
		lista.retirar(valor);

		return valor;
	}

	@Override
	public T peek() {
		if (estaVazia())
			throw new PilhaVaziaException();
		
		return lista.getPrimeiro().getInfo();
	}

	@Override
	public boolean estaVazia() {

		return lista.estaVazia();
	}

	@Override
	public void liberar() {
		while (!estaVazia()) {
			pop();
		}

	}

	@Override
	public String toString() {
		
		String resultado = "";
		NoLista<T> p = lista.getPrimeiro();

		while(p!= null) {
			resultado = resultado + p.getInfo();
			if (p.getProximo() != null)
				resultado = resultado + ",";
			p = p.getProximo();
		}
		return resultado;
	}

}
