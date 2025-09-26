package application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        String path = System.getProperty("user.dir") + "\\products.csv";
        String pathToWrite = System.getProperty("user.dir") + "\\summary.csv";
        List<String[]> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();

            while (line != null){
                String[] product = line.split(",");
                products.add(product);
                line = br.readLine();
            }

            String[] summarized = new String[products.size()];

            int count = 0;

            for (String[] product : products){
                String sb = product[0] +
                        "," +
                        String.format("%.2f",Double.parseDouble(product[1]) * Integer.parseInt(product[2]));
                summarized[count] = sb;
                count++;
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToWrite))){

                for (String product : summarized){
                    bw.write(product + "\n");
                }

            } catch (IOException e) {
                e.getStackTrace();
            }

        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}