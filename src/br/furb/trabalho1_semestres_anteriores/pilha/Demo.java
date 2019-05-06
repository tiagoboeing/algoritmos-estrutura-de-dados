package br.furb.trabalho1_semestres_anteriores.pilha;

public class Demo {
	
	public static void main(String[] args) {
		
		Pilha<Integer> p1 = new PilhaVetor<Integer>(10);
		//Pilha<Integer> p1 = new PilhaLista();
		
		p1.push(3);
		p1.push(2);
		p1.push(1);
		
		System.out.println(p1);
		
		while (!p1.estaVazia())
			System.out.println(p1.pop());
	} 

}
