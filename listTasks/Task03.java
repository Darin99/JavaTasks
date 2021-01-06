package listTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>();

        int numberOfInputs = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfInputs; i++) {
            List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));
            if (!tokens.contains("not")) {
                if (!names.contains(tokens.get(0))) {
                    names.add(tokens.get(0));
                } else {
                    System.out.printf("%s is already in the list!%n", tokens.get(0));
                }
            } else {
                if (names.contains(tokens.get(0))) {
                    names.remove(tokens.get(0));
                } else {
                    System.out.printf("%s is not in the list!%n", tokens.get(0));
                }
            }
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
