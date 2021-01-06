package setAndMapsTask;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> chemicals = new LinkedHashSet<>();

        for (int i = 0; i < number; i++) {
            String[] elements = scanner.nextLine().split("\\s+");

            for (int j = 0; j < elements.length; j++) {
                if (chemicals.isEmpty()) {
                    chemicals.add(elements[j]);
                } else {
                    if (chemicals.contains(elements[j])) {
                        continue;
                    } else {
                        chemicals.add(elements[j]);
                    }
                }
            }
        }
        chemicals.stream().sorted(String::compareTo).forEach(e -> System.out.print(e + " "));
    }
}
