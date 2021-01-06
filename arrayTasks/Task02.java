package arrayTasks;

import java.util.Scanner;

public class Task02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                if (secondArray[j].equals(firstArray[i])) {
                    System.out.print(secondArray[j] + " ");
                }
            }
        }
    }
}
