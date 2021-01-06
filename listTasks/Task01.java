package listTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task01 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> wagons = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacityOfEachWagon = Integer.parseInt(reader.readLine());

        String[] tokens = reader.readLine().split("\\s+");

        while (!tokens[0].equalsIgnoreCase("end")) {

            if (tokens.length > 1) {
                int passengers = Integer.parseInt(tokens[1]);
                wagons.add(wagons.size(), passengers);
            } else {
                int passengers = Integer.parseInt(tokens[0]);
                for (Integer wagon : wagons) {
                    if (wagon + passengers <= maxCapacityOfEachWagon) {
                        int index = wagons.indexOf(wagon);
                        wagons.set(index, wagon + passengers);
                        break;
                    }
                }
            }
            tokens = reader.readLine().split("\\s+");
        }
        System.out.print(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}