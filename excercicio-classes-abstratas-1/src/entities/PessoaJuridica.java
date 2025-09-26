package entities;

public class PessoaJuridica extends Pessoa{
    private Integer numeroFuncionarios;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, Double renda, Integer numeroFuncionarios) {
        super(nome, renda);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public Double impostoPago(){
        if (numeroFuncionarios <= 10) {
            return super.getRenda() * (0.16);
        }
        return super.getRenda() * (0.14);
    }
}
