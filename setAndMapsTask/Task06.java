package setAndMapsTask;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        LinkedHashMap<String, Integer> resourcesAndValues = new LinkedHashMap<>();

        while (!line.equals("stop")) {
            int number = Integer.parseInt(scanner.nextLine());

            if (!resourcesAndValues.containsKey(line)) {
                resourcesAndValues.put(line, number);
            } else {
                resourcesAndValues.put(line, resourcesAndValues.get(line) + number);
            }


            line = scanner.nextLine();
        }
        for (String s : resourcesAndValues.keySet()) {
            System.out.printf("%s -> %d%n", s, resourcesAndValues.get(s));
        }
    }
}
