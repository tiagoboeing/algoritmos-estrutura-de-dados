package Lista12;

public abstract class OrdenacaoAbstract<T extends Comparable<T>> {

	protected T info[];

	public T[] getInfo() {
		return info;
	}

	public void setInfo(T[] info) {
		this.info = info;
	}

	// Troca a posição dos elementos dados como parametros
	public void trocar(int a, int b) {
		T bkp;
		bkp = info[a];
		info[a] = info[b];
		info[b] = bkp;
	}

	public void ordenar() {

	}
}
