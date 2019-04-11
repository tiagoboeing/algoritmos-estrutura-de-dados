package br.furb.prova1_semestres_anteriores;

public class Aluno implements Comparable<Aluno>{
    private String nome;
    private int Matricula;

    public Aluno(int matricula) {
        this.Matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int Matricula) {
        this.Matricula = Matricula;
    }

    @Override
    public int compareTo(Aluno o) {

        if( this.getMatricula() < o.getMatricula()){
            return -1;
        }else if(this.getMatricula() == o.getMatricula()){
            return 0;
        }

        return 1;
    }


    @Override
    public String toString(){
        return Integer.toString(getMatricula());
    }
}
