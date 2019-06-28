package Questao2.lista;

public class Lista<T> {

	private NoLista<T> primeiro;
	private int qntNos;

	public Lista() {
		primeiro = null;
	}

	public NoLista<T> getPrimeiro() {
		return primeiro;
	}

	public void inserir(T info) {
		NoLista<T> novo = new NoLista();
		novo.setInfo(info);
		novo.setProximo(primeiro);
		this.primeiro = novo;
	}

	public void exibir() {
		NoLista<T> p = primeiro;

		while (p != null) {
			System.out.println(p.getInfo());
			p = p.getProximo();
		}
	}

	public boolean estaVazia() {
		return primeiro == null;
	}

	public NoLista<T> buscar(T info) {
		NoLista<T> p = primeiro;

		while (p != null) {
			if (p.getInfo().equals(info))
				return p;
			p = p.getProximo();
		}

		return null;
	}

	public void retirar(T info) {
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
		int qtdeNos = 0;
		NoLista<T> p = primeiro;

		while (p != null) {
			qtdeNos++;
			p = p.getProximo();
		}
		return qtdeNos;
	}

	public T obterUltimo() {
		if (estaVazia()) {
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

		NoLista<T> p1 = this.getPrimeiro();
		NoLista<T> p2 = outralista.getPrimeiro();

		while ((p1 != null) && (p2 != null)) {
			if (!(p1.getInfo().equals(p2.getInfo())))
				return false;

			p1 = p1.getProximo();
			p2 = p2.getProximo();
		}

		return ((p1 == null) && (p2 == null));
	}

	public NoLista<T> getNo(int idx) {
		if ((idx < 0))
			throw new IndexOutOfBoundsException();

		NoLista<T> p = getPrimeiro();
		while ((p != null) && (idx > 0)) {
			idx--;
			p = p.getProximo();

		}

		if (p == null)
			throw new IndexOutOfBoundsException();

		return p;
	}

}
