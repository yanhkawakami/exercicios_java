package entities;

public abstract class Pessoa {
    private String nome;
    private Double renda;

    public Pessoa(){
    }

    public Pessoa(String nome, Double renda){
        this.nome = nome;
        this.renda = renda;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public abstract Double impostoPago();
}
