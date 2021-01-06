package stacksAndQueuesTasks;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            if (tokens[0].equals("1")) {
                int numberToPush = Integer.parseInt(tokens[1]);
                numbers.push(numberToPush);

            } else if (tokens[0].equals("2")) {
                if (numbers.isEmpty()) {
                    continue;
                } else {
                    numbers.pop();
                }

            } else {
                System.out.println(Collections.max(numbers));
            }

        }
    }

}
