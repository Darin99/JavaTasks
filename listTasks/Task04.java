package listTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task04 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine()
                .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = reader.readLine();

        while (!command.equalsIgnoreCase("end")) {

            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(tokens[1]));
                    break;
                case "Insert": {
                    int index = Integer.parseInt(tokens[2]);
                    if (index > numbers.size() || index < 0) {
                        System.out.println("Invalid index");
                    } else {
                        int element = Integer.parseInt(tokens[1]);
                        numbers.add(index, element);
                    }
                    break;
                }
                case "Remove": {
                    int index = Integer.parseInt(tokens[1]);
                    if (index > numbers.size() || index < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.remove(index);
                    }
                    break;
                }
                case "Shift":
                    if (tokens[1].equals("left")) {
                        int countOfShifts = Integer.parseInt(tokens[2]);
                        for (int i = 0; i < countOfShifts; i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }

                    } else {
                        int element = Integer.parseInt(tokens[2]);
                        for (int i = 0; i < element; i++) {
                            numbers.add(0, numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }
            command = reader.readLine();
        }
        System.out.print(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
