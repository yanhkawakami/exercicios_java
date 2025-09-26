import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> products = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char option = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            switch (option){
                case 'c':
                    products.add(new Product(name, price));
                    break;
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YY): ");
                    sc.nextLine();
                    String manufactureDate = sc.nextLine();
                    products.add(new UsedProduct(name, price, sdf.parse(manufactureDate)));
                    break;
                case 'i':
                    System.out.print("Customs fee: ");
                    sc.nextLine();
                    Double customsFee = sc.nextDouble();
                    products.add(new ImportedProduct(name, price, customsFee));
                    break;
            }
        }

        System.out.println();
        for (Product product : products){
            System.out.println(product.priceTag());
        }

        sc.close();

    }
}
