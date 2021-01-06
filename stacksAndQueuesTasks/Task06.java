package stacksAndQueuesTasks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();

        ArrayDeque<Character> balancedBrackets = new ArrayDeque<>();

        boolean isTrue = true;

        for (int i = 0; i < brackets.length(); i++) {
            char thisBracket = brackets.charAt(i);

            if (thisBracket == '{' || thisBracket == '[' || thisBracket == '(') {
                balancedBrackets.push(thisBracket);
            } else {

                if (balancedBrackets.isEmpty()) {
                    isTrue = false;
                    continue;
                } else {
                    char currentBracket = balancedBrackets.pop();
                    if (currentBracket == '{' && thisBracket != '}') {
                        isTrue = false;
                        continue;
                    } else if (currentBracket == '[' && thisBracket != ']') {
                        isTrue = false;
                        continue;
                    } else if (currentBracket == '(' && thisBracket != ')') {
                        isTrue = false;
                        continue;
                    }
                }
            }
        }

        if (isTrue) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
