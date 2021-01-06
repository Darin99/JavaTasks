package matrixTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

        for (int rows = 0; rows < matrix.length; rows++) {
            int[] numbersToFill = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int cols = 0; cols < matrix.length; cols++) {
                matrix[rows][cols] = numbersToFill[cols];
            }
        }

        int sumOfFirstDiagonal = firstDiagonalSum(matrix);
        int sumOfSecondDiagonal = secondDiagonalSum(matrix);

        System.out.println(Math.abs(sumOfFirstDiagonal - sumOfSecondDiagonal));
    }

    private static int secondDiagonalSum(int[][] matrix) {

        int sum = 0;
        int counter = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {

            for (int col = counter++; col < matrix.length; col++) {
                sum += matrix[i][col];
                break;
            }
        }
        return sum;
    }

    private static int firstDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {

            for (int col = row; col < matrix.length; col++) {
                sum += matrix[row][col];
                break;
            }
        }
        return sum;
    }
}
