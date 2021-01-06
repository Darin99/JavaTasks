package listTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task10 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        StringBuilder text = new StringBuilder(reader.readLine());
        StringBuilder resultText = new StringBuilder();

        for (Integer number : numbers) {
            int index = 0;
            while (number > 0) {
                index += number % 10;
                number /= 10;
            }
            if (index > text.length() - 1) {
                index = index - text.length();
            }
            resultText.append(text.charAt(index));
            text.deleteCharAt(index);

        }
        System.out.println(resultText.toString());
    }
}