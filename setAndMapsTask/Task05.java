package setAndMapsTask;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        LinkedHashMap<String, String> contacts = new LinkedHashMap<>();

        while (!command.equals("search")) {

            String[] tokens = command.split("-");
            String name = tokens[0];
            String number = tokens[1];

            contacts.putIfAbsent(name, number);
            contacts.put(name, number);

            command = scanner.nextLine();
        }
        command = scanner.nextLine();

        while (!command.equals("stop")) {

            if (contacts.containsKey(command)) {
                System.out.printf("%s -> %s%n", command, contacts.get(command));
                contacts.remove(command);
            } else {
                System.out.printf("Contact %s does not exist.%n", command);

            }
            command = scanner.nextLine();
        }
    }
}