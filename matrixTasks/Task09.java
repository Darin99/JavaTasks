package matrixTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizeOfMatrix = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[sizeOfMatrix[0]][sizeOfMatrix[1]];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int row = sizeOfMatrix[0] - 1;
        int col = sizeOfMatrix[1] - 1;

        while (row != -1) {

            int c = col;
            int r = row;

            while (c < sizeOfMatrix[1] && r >= 0) {

                System.out.print(matrix[r--][c++] + " ");
            }
            col--;

            if (col == -1) {
                col = 0;
                row--;
            }
            System.out.println();
        }
    }
}
