package listTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task07 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrays = reader.readLine().split("\\|+");
        List<String> resultList = new ArrayList<>();

        for (int i = arrays.length - 1; i >= 0; i--) {

            String current = arrays[i].trim();

            if (current.isEmpty()) {
                continue;
            }

            List<String> currentArray = Arrays.stream(current
                    .split("\\s+")).collect(Collectors.toList());


            resultList.addAll(currentArray);
        }
        System.out.println(resultList.toString().replaceAll("[\\[\\],]", ""));
    }
}