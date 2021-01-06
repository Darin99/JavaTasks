package setAndMapsTask;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Task02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numberOfElements = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();

        for (int i = 0; i < numberOfElements[0]; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (set1.isEmpty()) {
                isAdd(set1, number);
            } else {
                if (set1.contains(number)) {
                    continue;
                } else {
                    set1.add(number);
                }
            }
        }

        for (int i = 0; i < numberOfElements[1]; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (set2.isEmpty()) {
                set2.add(number);
            } else {
                if (set2.contains(number)) {
                    continue;
                } else {
                    set2.add(number);
                }
            }
        }

        for (Integer integer : set1) {
            for (Integer integer1 : set2) {
                if (integer.equals(integer1)) {
                    System.out.print(integer + " ");
                }
            }
        }
    }

    private static void isAdd(LinkedHashSet<Integer> set1, int number) {
        set1.add(number);
    }
}