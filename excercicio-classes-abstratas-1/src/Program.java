import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        List<Pessoa> pessoas = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Tax payer #" + i + " data");
            System.out.print("Individual or company (i/c)? ");
            char tipo = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Anual income: ");
            Double renda = sc.nextDouble();

            switch (tipo) {
                case 'i':
                    System.out.print("Health expenditures: ");
                    Double gastosSaude = sc.nextDouble();
                    pessoas.add(new PessoaFisica(nome, renda, gastosSaude));
                    break;
                case 'c':
                    System.out.print("Number of employees: ");
                    int numeroFuncionarios = sc.nextInt();
                    pessoas.add(new PessoaJuridica(nome, renda, numeroFuncionarios));
                    break;
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        Double totalImpostoPago = 0.0;

        for (Pessoa pessoa : pessoas){
            System.out.println(pessoa.getName() + ": $ " + String.format("%.2f", pessoa.impostoPago()));
            totalImpostoPago += pessoa.impostoPago();
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f",totalImpostoPago));
    }
}