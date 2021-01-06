package arrayTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task04 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int number = array[0];
            System.arraycopy(array, 1, array, 0, array.length - 1);

            array[array.length - 1] = number;
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}