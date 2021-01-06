package listTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task08 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> words = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        String command = reader.readLine();

        while (!command.equalsIgnoreCase("3:1")) {

            String[] tokens = command.split("\\s+");
            String currentCommand = tokens[0];

            if (currentCommand.equalsIgnoreCase("merge")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);

                mergeCommand(words, startIndex, endIndex);

            } else {
                int index = Integer.parseInt(tokens[1]);
                int partitions = Integer.parseInt(tokens[2]);

                divideCommand(words, index, partitions);
            }
            command = reader.readLine();
        }

        System.out.println(String.join(" ", words));
    }

    private static void mergeCommand(List<String> words, int startIndex, int endIndex) {

        StringBuilder resultString = new StringBuilder();

        if (startIndex < 0) {
            startIndex = 0;
        }
        if (endIndex >= words.size()) {
            endIndex = words.size() - 1;
        }

        int addIndex = startIndex;

        for (int i = startIndex; i <= endIndex; i++) {
            String text = words.get(addIndex);
            resultString.append(text);
            words.remove(addIndex);
        }

        if (addIndex <= words.size()) {
            words.add(addIndex, resultString.toString());
        }
    }

    private static void divideCommand(List<String> words, int index, int partitions) {
        String text = words.get(index);
        words.remove(index);

        int portionLength = text.length() / partitions;

        int startIndex = 0;
        int endIndex = portionLength;
        if (text.length() % partitions == 0) {
            for (int i = 0; i < partitions; i++) {
                words.add(index + i, text.substring(startIndex, endIndex));
                startIndex += portionLength;
                endIndex += portionLength;
            }
        } else {
            for (int i = 0; i < partitions; i++) {
                if (i + 1 == partitions) {
                    words.add(index + i, text.substring(startIndex));
                } else {
                    words.add(index + i, text.substring(startIndex, endIndex));
                }
                startIndex += portionLength;
                endIndex += portionLength;
            }
        }
    }
}