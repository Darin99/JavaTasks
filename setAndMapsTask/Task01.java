package setAndMapsTask;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Task01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Set<String> names = new LinkedHashSet<>();
        for (int i = 0; i < number; i++) {
            String name = scanner.nextLine();
            if (names.isEmpty()) {
                names.add(name);
            } else {
                if (names.contains(name)) {
                    continue;
                } else {
                    names.add(name);
                }
            }
        }
        names.forEach(System.out::println);
    }
}