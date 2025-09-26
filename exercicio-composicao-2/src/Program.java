import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        Date moment = new Date();

        SimpleDateFormat sdf_birthDate = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("E-mail: ");
        String email = sc.next();
        System.out.print("Birth date: ");
        String birthDate = sc.next();

        Client client = new Client(name, email, sdf_birthDate.parse(birthDate));

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.next();

        System.out.print("How many items to this order? ");
        int numItems = sc.nextInt();

        Order order = new Order(moment, OrderStatus.valueOf(status), client);

        for (int i = 1; i <= numItems; i++) {
            System.out.println("Enter the #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            Product product = new Product(productName, price);
            OrderItem orderItem = new OrderItem(quantity, price, product);
            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println(order);




        sc.close();


    }
}
