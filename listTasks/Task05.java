package listTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task05 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] specialNumbers = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;

        while (numbers.contains(specialNumbers[0])) {

            int bomb = specialNumbers[0];
            int power = specialNumbers[1];

            int index = numbers.indexOf(bomb);

            int begin = Math.max(index - power, 0);

            if (index > begin) {
                numbers.subList(begin, index).clear();
            }
            index = numbers.indexOf(bomb);

            int end = Math.min(index + power, numbers.size() - 1);
            if (end >= index) {
                numbers.subList(index, end + 1).clear();
            }
        }

        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
