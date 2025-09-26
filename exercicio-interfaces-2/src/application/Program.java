package application;

import model.services.BrazilInterestService;
import model.services.InterestService;

import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        System.out.println();

        System.out.println("Payment after " + months + " months in Brazil:");
        InterestService is_bra = new BrazilInterestService(2.0);
        System.out.println(String.format("%.2f", is_bra.payment(amount, months)));

        System.out.println();

        System.out.println("Payment after " + months + " months in USA:");
        InterestService is_usa = new BrazilInterestService(1.0);
        System.out.println(String.format("%.2f", is_usa.payment(amount, months)));

        sc.close();
    }
}