package matrixTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rotateData = scanner.nextLine().split("[()]");
        int degrees = Integer.parseInt(rotateData[1]) % 360;

        String word = scanner.nextLine();
        List<String> inputWords = new ArrayList<>();
        int bestLength = word.length();

        while (!word.equals("END")) {
            inputWords.add(word);
            word = scanner.nextLine();
            if (word.length() > bestLength) {
                bestLength = word.length();
            }
        }
        char[][] matrix = new char[inputWords.size()][bestLength];

        for (int i = 0; i < inputWords.size(); i++) {
            for (int j = 0; j < bestLength; j++) {
                if (j > inputWords.get(i).length() - 1) {
                    matrix[i][j] = ' ';
                } else {
                    matrix[i][j] = inputWords.get(i).charAt(j);
                }
            }
        }

        if (degrees == 90) {

            for (int c = 0; c < bestLength; c++) {
                for (int r = matrix.length - 1; r >= 0; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (degrees == 180) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = bestLength - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        } else if (degrees == 270) {

            for (int i = bestLength - 1; i >= 0; i--) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[j][i]);
                }
                System.out.println();
            }

        } else {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < bestLength; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}