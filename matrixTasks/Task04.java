package matrixTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task04 {

    private static int sum = 0;
    private static int[][] tempMatrix = new int[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizeOfMatrix = getInts(scanner);

        int rows = sizeOfMatrix[0];
        int cols = sizeOfMatrix[1];

        int matrix[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = 0;

        int[][] bestMatrix = new int[3][3];

        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                calculateMatrixSum(matrix, row, col);

                if (sum > maxSum) {
                    maxSum = sum;
                    bestMatrix = tempMatrix;
                }
            }
        }

        System.out.println("Sum = " + maxSum);

        for (int row = 0; row < bestMatrix.length; row++) {
            for (int col = 0; col < bestMatrix.length; col++) {
                System.out.print(bestMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void calculateMatrixSum(int[][] matrix, int r, int c) {

        sum = 0;
        tempMatrix = new int[3][3];

        int matrixRow = 0;

        for (int row = r - 1; row <= r + 1; row++) {
            int matrixCol = 0;
            for (int col = c - 1; col <= c + 1; col++) {
                sum += matrix[row][col];
                tempMatrix[matrixRow][matrixCol++] = matrix[row][col];
            }
            matrixRow++;
        }
    }

    private static int[] getInts(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}