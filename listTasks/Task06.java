package listTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task06 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> firstHand = Arrays.stream(reader.readLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondHand = Arrays.stream(reader.readLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (true) {

            if (firstHand.size() <= 0) {
                int sum = 0;
                for (Integer integer : secondHand) {

                    sum += integer;
                }
                System.out.printf("Second player wins! Sum: %d%n", sum);
                break;
            }

            if (secondHand.size() <= 0) {
                int sum = 0;

                for (Integer integer : firstHand) {

                    sum += integer;
                }
                System.out.printf("First player wins! Sum: %d", sum);
                break;
            }

            if (firstHand.get(0) > secondHand.get(0)) {
                firstHand.add(firstHand.get(0));
                firstHand.remove(0);

                firstHand.add(secondHand.get(0));
                secondHand.remove(0);

            } else if (secondHand.get(0) > firstHand.get(0)) {
                secondHand.add(secondHand.get(0));
                secondHand.remove(0);

                secondHand.add(firstHand.get(0));
                firstHand.remove(0);
            } else {
                firstHand.remove(0);
                secondHand.remove(0);
            }
        }
    }
}