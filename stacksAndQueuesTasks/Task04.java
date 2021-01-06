package stacksAndQueuesTasks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Task04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int numbersOfElementsToPush = numbers[0];
        int numbersOfElementsToPop = numbers[1];
        int elementToFind = numbers[2];

        ArrayDeque<Integer> newNumbers = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).limit(numbersOfElementsToPush)
                .forEach(newNumbers::offer);

        for (int i = 0; i < numbersOfElementsToPop; i++) {
            newNumbers.poll();
        }

        if (newNumbers.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (newNumbers.contains(elementToFind)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(newNumbers));
        }

    }
}
