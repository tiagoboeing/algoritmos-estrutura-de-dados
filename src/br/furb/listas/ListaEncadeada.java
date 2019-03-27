package br.furb.listas;

import br.furb.Model.NodeList;

public class ListaEncadeada<T> {

    private NodeList<T> first;

    public static void main(String[] args) {
        ListaEncadeadaTests tests = new ListaEncadeadaTests();

//        tests.caso1();
//        tests.caso2();
//        tests.caso3();
//        tests.caso4();
//        tests.caso5();
//        tests.caso6();
//        tests.caso7();
//        tests.caso8();
//        tests.caso9();
//        tests.caso10();
//        tests.caso11();
//        tests.caso12();
//        tests.caso13();
//        tests.caso14();
    }

    /* Initialize the list and define the first node as null */
    public ListaEncadeada() {
        first = null;
    }

    /*
    * Insert a value in list
    * @param value to insert
    */
    public void insert(T info){
        NodeList<T> n = new NodeList<>();
        n.setInfo(info);
        n.setNext(first);
        this.first = n;
    }

    /* insert a element and define the predecessor as the node saved before */
    public void insertTest(T info){
        NodeList<T> n = new NodeList<>();
        n.setInfo(info);
        n.setNext(first);
        this.first = n;
    }

    public void remove(T info){
        NodeList<T> previous = null;
        NodeList<T> f = first;

        /* search a node for remove and save the previous */
        while((f != null) && (!f.getInfo().equals(info))){
            previous = f;
            f = f.getNext();
        }

        /* if node as encountered, remove from list */
        if(f != null){
            if(previous == null){
                this.first = f.getNext();
            } else {
                previous.setNext(f.getNext());
            }
        }
    }

    public int getLength(){
        int qttOfNodes = 0;
        NodeList<T> f = first;
        while(f != null){
            qttOfNodes++;
            f = f.getNext();
        }
        return qttOfNodes;
    }

    public boolean isEmpty(){
        return first == null ? true : false;
    }

    public NodeList<T> getNode(int pos){
        if(pos < 0){ throw new IndexOutOfBoundsException(); }

        NodeList<T> f = getFirst();
        for(int i = 0; (f != null) && (i < pos); i++){
            f = f.getNext();
        }

        if(f == null){ throw new IndexOutOfBoundsException(); }
        return f;
    }

    /*
    * search in NodeList if element exists
    * @param: element for locate in list
    * @return a node
    */
    public NodeList<T> search(T info){
        NodeList<T> f = first;

        while (f != null){
            if(f.getInfo().equals(info)){
                return f;
            }
            f = f.getNext();
        }
        return null;
    }

    public void show() {
        NodeList<T> f = first;

        while(f != null){
            System.out.println(f.getInfo());
            f = f.getNext();
        }
    }

    public ListaEncadeada<T> createSubList(int start, int end){
        if(start >= 0){
            ListaEncadeada<T> newList = new ListaEncadeada<>();
            NodeList<T> f = first;

            int i = 0;
            while(f != null){
                if(i >= start && i <= end){
                    newList.insert(f.getInfo());
                    if(i == end){
                        return newList;
                    }
                    f = f.getNext();
                    i++;
                }
            }
            return null;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public NodeList<T> getFirst() {
        return first;
    }

    @Override
    public String toString(){
        NodeList<T> f = first;
        String message = "";

        while(f != null){
            message = message == "" ?  (message + f.getInfo()) : (message + "," + f.getInfo());
            f = f.getNext();
        }
        return message;
    }

}
