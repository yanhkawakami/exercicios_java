package applications;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        Map<String, Integer> votes = new LinkedHashMap<>();

        System.out.print("Enter full file path: ");
        String path = scanner.nextLine();
        scanner.close();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                int candidateVotes = Integer.parseInt(fields[1]);
                if (votes.containsKey(name)) {
                    candidateVotes += votes.get(name);
                }
                votes.put(name, candidateVotes);
                line = br.readLine();
            }

            for (String name : votes.keySet()){
                System.out.println(name + ": " + votes.get(name));
            }

        } catch (IOException e){
            e.getStackTrace();
        }

    }
}