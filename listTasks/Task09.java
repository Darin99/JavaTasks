package listTasks;

import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> newNumbers = new ArrayList<>();
        int sum = 0;

        while (numbers.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());


            if (index < 0) {
                int token = numbers.get(0);
                newNumbers.add(token);
                numbers.remove(0);
                numbers.add(0, numbers.get(numbers.size() - 1));
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) > token) {
                        int number = numbers.get(i) - token;
                        numbers.set(i, number);
                    } else {
                        int number = numbers.get(i) + token;
                        numbers.set(i, number);
                    }
                }
                continue;
            } else if (index > numbers.size() - 1) {
                int token = numbers.get(numbers.size() - 1);
                newNumbers.add(token);
                numbers.remove(numbers.size() - 1);
                numbers.add(numbers.get(0));
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) > token) {
                        int number = numbers.get(i) - token;
                        numbers.set(i, number);
                    } else {
                        int number = numbers.get(i) + token;
                        numbers.set(i, number);
                    }
                }
                continue;
            }

            int currentNumber = numbers.get(index);
            newNumbers.add(currentNumber);

            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) > currentNumber) {
                    int number = numbers.get(i) - currentNumber;
                    numbers.set(i, number);
                } else {
                    int number = numbers.get(i) + currentNumber;
                    numbers.set(i, number);
                }
            }
            numbers.remove(index);
        }
        for (Integer newNumber : newNumbers) {
            sum += newNumber;
        }
        System.out.println(sum);
    }
}