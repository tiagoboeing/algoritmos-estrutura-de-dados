package Lista11;

public class Demo {

    public static void main(String[] args) {

        ArvoreBinariaBusca<Integer> a = new ArvoreBinariaBusca<>();

        /*
        //Caso 1
        
        a.inserir(50);
        a.inserir(30);
        a.inserir(70);
        a.inserir(40);
        a.inserir(25);
        a.inserir(75);
        a.inserir(65);
        a.inserir(35);
        a.inserir(60);
                
        System.out.println(a.toString());
         */
        //Caso 2
        /* 
        a.inserir(50);
        a.inserir(30);
        a.inserir(25);
        a.inserir(40);
        System.out.println(a.toString());
        
        a.retirar(25);
        System.out.println(a.toString());
         */
        //Caso 3
        /*
        a.inserir(80);
        a.inserir(52);
        a.inserir(90);
        a.inserir(48);
        a.inserir(71);
        a.inserir(63);
        a.inserir(67);
        System.out.println(a.toString());
        a.retirar(71);
        System.out.println(a.toString());
         */
        //Caso 4
        /*
        a.inserir(250);
        a.inserir(38);
        a.inserir(26);
        a.inserir(72);
        a.inserir(55);
        a.inserir(90);
        a.inserir(41);
        a.inserir(60);
        a.inserir(43);
        a.inserir(78);
        a.inserir(92);
        a.inserir(74);
        a.inserir(38);

        System.out.println(a.toString());
        a.retirar(38);
        System.out.println(a.toString());
         */
        //Questão 3
        /*
        a.inserir(50);
        a.inserir(30);
        a.inserir(80);
        a.inserir(15);
        a.inserir(45);
        a.inserir(45);
        System.out.println(a.toString());
         */
        //Questão 4
        a.inserir(40);
        a.inserir(15);
        a.inserir(10);
        a.inserir(30);
        a.inserir(22);
        a.inserir(28);
        a.inserir(50);
        System.out.println(a.toString());
        a.retirar(15);
        System.out.println(a.toString());
    }

}
