package listTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task02 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String[] tokens = reader.readLine().split("\\s+");

        while (!tokens[0].equalsIgnoreCase("end")) {

            int element = Integer.parseInt(tokens[1]);
            if (tokens[0].equalsIgnoreCase("delete")) {

                while (numbers.contains(element)) {
                    numbers.remove(Integer.valueOf(element));
                }

            } else {

                int index = Integer.parseInt(tokens[2]);

                if (index >= numbers.size() || index < 0) {
                    tokens = reader.readLine().split("\\s+");
                    continue;
                }

                numbers.add(index, element);

            }
            tokens = reader.readLine().split("\\s+");
        }

        System.out.print(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
