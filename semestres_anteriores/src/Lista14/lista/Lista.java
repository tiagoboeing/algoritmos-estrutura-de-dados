package Lista14.lista;

import java.awt.List;


public class Lista<T> {

	private NoLista<T> primeiro;
	private int qntNos;

	public Lista() {

		// Cria lista vazia

		primeiro = null;
	}

	public NoLista<T> getPrimeiro() {
		return primeiro;
	}

	public void inserir(T info) {

		// Inclui novo elemento na lista
		// Constante no pior e melhor caso O(1)

		NoLista<T> novo = new NoLista();
		novo.setInfo(info);
		novo.setProximo(primeiro);
		this.primeiro = novo;
	}

	public void exibir() {
		// Linear e pior caso linear O(n)
		// Exibi o conteudo armazenado nos nós da lista encadeada.

		NoLista<T> p = primeiro;

		while (p != null) {

			System.out.println(p.getInfo());

			p = p.getProximo();

		}

	}

	public boolean estaVazia() {
		// retornar true se a lista estiver vazia ou false se tiver algum nó.
		// Constante O(1)
		return primeiro == null;

	}

	public NoLista<T> buscar(T info) {
		// procurar na lista o n� cujo conte�do seja igual a variavel e retornar
		// este nó.
		// Pior caso linear O(n) e no melhor O(1)
		NoLista<T> p = primeiro;

		while (p != null) {

			if (p.getInfo().equals(info))
				return p;
			p = p.getProximo();

		}
		// Sen�o retornar null
		return null;
	}

	public void retirar(T info) {
		// remover o primeiro nó que for encontrado que contiver o dado
		// fornecido como argumento.
		// Pior caso caso O(n) e no melhor O(1)

		NoLista<T> p = primeiro;
		NoLista<T> anterior = null;

		while ((p != null) && (!p.getInfo().equals(info))) {
			anterior = p;
			p = p.getProximo();

		}
		if (p != null) {
			if (anterior == null) {
				this.primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());

				qntNos--;
			}

		}

	}

	public int obterComprimento() {
		// Retornar a quantidade de nós encadeados na lista.
		// Pior caso e melhor caso O(n)
		int qtdeNos = 0;

		NoLista<T> p = primeiro;

		while (p != null) {
			qtdeNos++;
			p = p.getProximo();

		}

		return qtdeNos;
	}

	public T obterUltimo() {
		/*
		 * Devera retornar o valor do ultimo no da lista encadeada, aquele que
		 * esta na extremidade oposta do primeiro nos da lista.
		 */

		if (estaVazia()) {
			// Se a lista estiver vazia, lanca uma excecao
			throw new ListaVaziaException();

		}
		NoLista<T> ultimo = null;

		NoLista<T> p = primeiro;
		while (p != null) {
			ultimo = p;
			p = p.getProximo();
		}

		return ultimo.getInfo();
	}

	@Override
	public boolean equals(Object lista) {

		if (this == lista)
			return true;
		if (lista == null)
			return false;
		if (getClass() != lista.getClass())
			return false;

		Lista<T> outralista = (Lista<T>) lista;

		/*
		 * if(this.obterComprimento()!= outralista.obterComprimento()) return
		 * false;
		 */

		NoLista<T> p1 = this.getPrimeiro();
		NoLista<T> p2 = outralista.getPrimeiro();

		while ((p1 != null) && (p2 != null)) {
			if (!(p1.getInfo().equals(p2.getInfo())))
				return false;

			p1 = p1.getProximo();
			p2 = p2.getProximo();

		}

		// if((p1 == null) && (p2 == null))
		// return true;
		// else
		// return false;

		return ((p1 == null) && (p2 == null));
	}

	public NoLista<T> getNo(int idx) {

		// O(n) e no melhor caso O(1)
		// Prejudicial ao vetor, pois o vetor n�o precisar ser percorrido.

		if ((idx < 0))
			throw new IndexOutOfBoundsException();

		NoLista<T> p = getPrimeiro();
		while ((p != null) && (idx > 0)) {
			idx--;
			p = p.getProximo();

		}

		// NoLista<T> p = getPrimeiro();
		// for(int i=0; (p!= null && (i<idx); i++){
		// p= p.getProximo();
		// }

		if (p == null)
			throw new IndexOutOfBoundsException();

		return p;
	}

	public Lista<T> criarInvertida() {

		// O(n) no melhor e pior caso.

		Lista<T> nova = new Lista<T>();
		NoLista<T> p = getPrimeiro();

		while (p != null) {
			nova.inserir(p.getInfo());
			p = p.getProximo();

		}
		return nova;
	}

}
