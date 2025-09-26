package entities;

public class PessoaFisica extends Pessoa{
    private Double gastosSaude;

    public PessoaFisica(){
    }

    public PessoaFisica(String nome, Double renda, Double gastosSaude) {
        super(nome, renda);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public Double impostoPago(){
        double impostoSemSaude = 0.0;
        if (super.getRenda() < 20000.00) {
            impostoSemSaude = super.getRenda() * (0.15);
        } else {
            impostoSemSaude = super.getRenda() * (0.25);
        }
        return impostoSemSaude - (gastosSaude * 0.5);
    }
}
