package application;


import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        List<Employee> employeesList = new ArrayList<>();

        System.out.print("Enter full file path: ");
        String path = sc.next();

        System.out.print("Enter salary: ");
        Double salaryThreshold = sc.nextDouble();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                employeesList.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            Comparator<String> nameComp = (e1, e2) -> e1.toUpperCase().compareTo(e2.toUpperCase());

            employeesList
                    .stream()
                    .filter(e -> e.getSalary() > salaryThreshold)
                    .map(e -> e.getEmail())
                    .sorted(nameComp)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

            System.out.print("Sum of salary of people whose name starts with 'M': ");
            Double sum = employeesList
                            .stream()
                            .filter(e -> e.getName().charAt(0) == 'M')
                            .map(e -> e.getSalary())
                            .reduce(0.0, Double::sum);
            System.out.println(sum);


        } catch (IOException e) {
            e.getStackTrace();
        }

        sc.close();

    }
}