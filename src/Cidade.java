public class Cidade {
    private String nome;
    private String uf;
    private boolean Capital;

    public Cidade(String uf, String nome, boolean Capital) {
        this.uf = uf;
        this.nome = nome;
        this.Capital = Capital;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCapital(boolean Capital){
        this.Capital = Capital;

    }
    public boolean Capital() {
        return Capital;
    }

    @Override
    public String toString() {
        return String.format("%s - %s%s", nome, uf, Capital ? "(Capital)" : "");
    }

}
