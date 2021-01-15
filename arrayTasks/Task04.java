package arrayTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task04 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            shift(array);
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void shift(int[] array) {
        int temp = array[0];

        for (int i = 0; i <array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = temp;
    }
}