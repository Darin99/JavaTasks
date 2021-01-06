package stacksAndQueuesTasks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Task02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int operationPush = numbers[0];
        int operationPop = numbers[1];
        int operationFind = numbers[2];

        ArrayDeque<Integer> newNumbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).limit(operationPush)
                .forEach(newNumbers::push);


        for (int i = 0; i < operationPop; i++) {
            newNumbers.pop();
        }

        if (newNumbers.contains(operationFind)) {
            System.out.println("true");
        } else {
            if (newNumbers.isEmpty()) {
                System.out.println(0);
                return;
            }
            int minNumber = Integer.MAX_VALUE;
            while (!newNumbers.isEmpty()) {
                int currentNumber = newNumbers.pop();
                if (currentNumber < minNumber) {
                    minNumber = currentNumber;
                }
            }
            System.out.println(minNumber);
        }
    }
}