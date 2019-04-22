package br.furb.pilha_lista;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    /*
    Getter da variável primeiro
    @return Primeiro nó da lista
     */
    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    /*
    Insere um novo valor na lista
    @param info Valor a ser inserido na lista
     */
    public void inserir(T info) {
        //new NoLista serve APENAS para quando for necessário guardar dados
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    public void inserirTeste(T info, int idx) {
        //new NoLista serve APENAS para quando for necessário guardar dados
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        this.primeiro = novo;

    }

    /*
A variável “p” armazena a referência de um nós da
lista.

O loop “navega” na estrutura, isto é, percorre todos
os nós da estrutura
     */
    public void exibir() {
        NoLista<T> p = primeiro;

        while (p != null) {
            System.out.println(p.getInfo());

            p = p.getProximo();
        }
    }

    /*
    Avaliar se a lista está vazia ou não
    @return True se a lista estiver vazia
     */
    public boolean estaVazia() {
        return primeiro == null;
    }

    /*
    Busca um nó na lista encadeada.
    Algoritmo roda o while até chegar no último nó e tentar ir para o próximo,
    aí a variável p guarda 'null' e sai do while.
    @param info dado a ser localizado
    @return Nó contendo dado a ser localizado
     */
    public NoLista<T> buscar(T info) {
        NoLista<T> p = primeiro;

        while (p != null) {
            //se achou...
            //(p.getInfo().equals(info))
            if (p.getInfo().equals(info)) {
                return p;
            }
            //se nao, vai para o proximo
            p = p.getProximo();
        }
        return null;
    }

    /*
        Retira um dado da lista encadeada
        @param dado a ser retirado da lista encadeada
     */
    public void retirar(T info) {
        //NoLista<T> = guarda endereços de nó
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        //Procura nó que contém dado a ser removido guardando o anterior
        while ((p != null) && (p.getInfo().equals(info))) {
            anterior = p;
            p = p.getProximo();
        }

        //Se achou nó, retira-o da lista
        if (p != null) {
            /*Se o nó a ser retirado é o primeiro da lista, o primeiro recebe o
            valor do próximo. 
            Também pode ser usado o if (primeiro == p)
             */
            if (anterior == null) {
                this.primeiro = p.getProximo();

            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }

    /*
    Calcula a quantidade de nós da lista
    @return quantidade de elementos da lista
     */
    public int obterComprimento() {
        int qtdeNos = 0;

        NoLista<T> p = primeiro;

        /*
        executa enquanto não chegar ao final da lista, incrementa a variável qtdeNos
        e retorna a quantidade de iterações
         */
        while (p != null) {
            qtdeNos++;
            p = p.getProximo();
        }
        return qtdeNos;
    }

    /*
    Obtém um nó na lista, partindo da posição do nó na lista
    @param idx Posição do nó na lista
    @return Nó
     */
    public NoLista<T> obterNo(int idx) {

        if (idx < 0) {
            throw new IndexOutOfBoundsException();
        }

        NoLista<T> p = getPrimeiro();
        for (int i = 0; (p != null) && (i < idx); i++) {
            p = p.getProximo();
        }

        if (p == null) {
            throw new IndexOutOfBoundsException();
        }
        return p;

    }

    @Override
    public String toString() {

        NoLista<T> p = primeiro;
        String conteudo = "";

        while (p != null) {
            if (conteudo != "") {
                conteudo = conteudo + ", " + p.getInfo();
            } else {
                conteudo = conteudo + p.getInfo();
            }
            p = p.getProximo();
        }
        return conteudo;
    }

    public ListaEncadeada<T> criarSubLista(int inicio, int fim) {
        if (inicio < 0) {
            throw new IndexOutOfBoundsException();
        }
        ListaEncadeada<T> nova = new ListaEncadeada<>();

        NoLista<T> p = primeiro;

        int i = 0;

        while (p != null) {
            if (i >= inicio && i <= fim) {
                nova.inserir(p.getInfo());
                if (i == fim) {
                    return nova;
                }
                p = p.getProximo();
                i++;
            }
            throw new IndexOutOfBoundsException();

        }
        return null;
    }

}
