package matrixTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, rows, cols, scanner);


        while (true) {

            String line = scanner.nextLine();

            if (line.equals("END")) {
                break;
            }

            String[] tokens = line.split("\\s+");

            if (!tokens[0].equals("swap") || tokens.length != 5) {

                System.out.println("Invalid input!");
                continue;

            }

            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);

            if (row1 > rows || row2 > rows || col1 > cols || col2 > cols) {

                System.out.println("Invalid input!");
                continue;
            }

            String temp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;

            for (int i = 0; i < matrix.length; i++) {

                for (int j = 0; j < cols; j++) {

                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void fillMatrix(String[][] matrix, int rows, int cols, Scanner scanner) {

        for (int i = 0; i < rows; i++) {

            String[] inputArray = scanner.nextLine().split("\\s+");

            for (int j = 0; j < cols; j++) {

                matrix[i][j] = inputArray[j];
            }
        }
    }
}