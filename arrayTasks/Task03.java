package arrayTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];


        for (int i = 0; i < n; i++) {

            int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            if (i % 2 == 0) {
                firstArray[i] = array[1];
                secondArray[i] = array[0];
            } else {
                firstArray[i] = array[0];
                secondArray[i] = array[1];
            }
        }

        for (int i : secondArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : firstArray) {
            System.out.print(i + " ");
        }
    }
}