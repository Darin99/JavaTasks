package stacksAndQueuesTasks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String text = "";
        ArrayDeque<String> history = new ArrayDeque<>();

        for (int i = 0; i < num; i++) {

            String[] commands = scanner.nextLine().split("\\s+");

            int typeOfCmd = Integer.parseInt(commands[0]);

            if (typeOfCmd == 1) {
                StringBuilder textToAdd = new StringBuilder(commands[1]);
                history.push(text);
                text += textToAdd;


            } else if (typeOfCmd == 2) {
                history.push(text);
                int numberOfTextToDelete = Integer.parseInt(commands[1]);
                for (int j = 0; j < numberOfTextToDelete; j++) {
                    text = text.substring(0, text.length() - 1);
                }

            } else if (typeOfCmd == 3) {
                int indexToPrint = Integer.parseInt(commands[1]);

                if (indexToPrint >= text.length()) {
                    System.out.println(text.charAt(text.length() - 1));
                } else {
                    System.out.println(text.charAt(indexToPrint - 1));
                }
            } else {
                text = history.pop();
            }
        }
    }
}