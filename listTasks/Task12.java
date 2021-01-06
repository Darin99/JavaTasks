package listTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task12 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> firstNumbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondNumbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> mixedList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        int firstBorder = firstNumbers.get(firstNumbers.size() - 1);
        int secondBorder = firstNumbers.get(firstNumbers.size() - 2);
        firstNumbers.remove(firstNumbers.size() - 1);
        firstNumbers.remove(firstNumbers.size() - 1);

        for (int i = 0; i < Math.min(firstNumbers.size(), secondNumbers.size()); i++) {
            mixedList.add(firstNumbers.get(i));
            mixedList.add(secondNumbers.get(secondNumbers.size() - 1 - i));
        }
        for (Integer number : mixedList) {
            if (number > Math.min(firstBorder, secondBorder) && number < Math.max(firstBorder, secondBorder)) {
                resultList.add(number);
            }
        }
        Collections.sort(resultList);
        System.out.println(resultList.toString().replaceAll("[\\[\\],]", ""));
    }
}