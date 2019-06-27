package Trabalho2.arvoreBinaria;

public abstract class ArvoreBinariaAbstract<T> {

	private NoArvoreBinaria<T> raiz;

	public NoArvoreBinaria<T> getRaiz() {
		return raiz;
	}

	public ArvoreBinariaAbstract() {
		raiz = null;
	}

	protected void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;

	}

	public boolean estaVazia() {

		return (raiz == null);

	}

	public boolean pertence(T info) {

		return pertence(raiz, info);
	}

	private boolean pertence(NoArvoreBinaria<T> no, T info) {

		if (no == null)
			return false;

		else if (no.getInfo().equals(info))
			return true;
		else if (pertence(no.getEsquerda(), info))
			return true;
		else
			return pertence(no.getDireita(), info);

	}

	@Override
	public String toString() {

		return arvorePre(raiz);
	}

	private String arvorePre(NoArvoreBinaria<T> no) {

		if (no == null)
			return "<>";
		else
			return "<" + no.getInfo() + arvorePre(no.getEsquerda())
					+ arvorePre(no.getDireita()) + ">";

	}

	public String arvorePre() {

		return "";
	}
}
