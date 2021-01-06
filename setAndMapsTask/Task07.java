package setAndMapsTask;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String name = "";
        LinkedHashMap<String, String> namesAndEmails = new LinkedHashMap<>();
        while (!command.equals("stop")) {
            if (!command.contains("@")) {
                name = command;
                namesAndEmails.put(name, "");
            } else {
                namesAndEmails.put(name, command);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, String> stringStringEntry : namesAndEmails.entrySet()) {
            if (stringStringEntry.getValue().endsWith("com") || stringStringEntry.getValue().endsWith("us")
                    || stringStringEntry.getValue().endsWith("uk")) {
                continue;
            } else {
                System.out.printf("%s -> %s%n", stringStringEntry.getKey(), stringStringEntry.getValue());
            }
        }
    }
}
