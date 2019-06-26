public class NoArvore<Integer> {

    private int info;
    private NoArvore<Integer> primeiro; //primeiro filho
    private NoArvore<Integer> proximo; //proximo irmao

    public NoArvore(int info) {
        this.info = info;
        primeiro = null;
        proximo = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void inserirFilho(NoArvore<Integer> sa){
        sa.setProximo(primeiro);
        setPrimeiro(sa);
    }

    public NoArvore<Integer> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoArvore<Integer> primeiro) {
        this.primeiro = primeiro;
    }

    public NoArvore<Integer> getProximo() {
        return proximo;
    }

    public void setProximo(NoArvore<Integer> proximo) {
        this.proximo = proximo;
    }
    
}
