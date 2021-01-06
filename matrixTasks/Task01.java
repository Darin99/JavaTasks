package matrixTasks;

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        if (pattern.equals("A")) {
            fillMatrixWithFirstPattern(matrix);
        } else {
            fillTheMatrixWithSecondPattern(matrix);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillTheMatrixWithSecondPattern(int[][] matrix) {
        int value = 1;

        for (int row = 0; row < matrix.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < matrix.length; col++) {
                    matrix[col][row] = value++;
                }
            } else {
                for (int col = matrix.length - 1; col >= 0; col--) {
                    matrix[col][row] = value++;
                }
            }
        }
    }

    private static void fillMatrixWithFirstPattern(int[][] matrix) {
        int value = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[col][row] = value++;
            }
        }
    }
}
