package application;

import entities.Student;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        Set<Student> students = new HashSet<>();
        Set<Character> courseList = new HashSet<>();
        courseList.add('A');
        courseList.add('B');
        courseList.add('C');

        for (Character c : courseList){
            System.out.print("How many students for course " + c + "? ");
            int n = scanner.nextInt();
            for (int i = 1; i <= n; i++){
                int studentId = scanner.nextInt();
                students.add(new Student(studentId));
            }
        }

        System.out.println("Total students: " + students.size());

    }
}