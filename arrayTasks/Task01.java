package arrayTasks;

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        int sumOfPeople = 0;
        for (int i = 0; i < number; i++) {

            int people = Integer.parseInt(scanner.nextLine());
            sumOfPeople += people;
            System.out.print(people + " ");
        }
        System.out.println();
        System.out.println(sumOfPeople);
    }
}