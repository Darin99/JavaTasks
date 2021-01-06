package listTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task11 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        List<String> numbers = new ArrayList<>();
        List<Character> symbols = new ArrayList<>();
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                numbers.add(String.valueOf(text.charAt(i)));
            } else {
                symbols.add(text.charAt(i));
            }
        }

        for (int i = 0; i < numbers.size(); i++) {

            if (i % 2 == 0) {
                takeList.add(Integer.parseInt(numbers.get(i)));
            } else {
                skipList.add(Integer.parseInt(numbers.get(i)));
            }
        }
        for (int i = 0; i < Math.min(skipList.size(), takeList.size()); i++) {
            int numbersToSkip = skipList.get(i);
            int numbersToTake = takeList.get(i);

            if (numbersToTake > symbols.size()) {
                numbersToTake = symbols.size();
            }

            for (int j = 0; j < numbersToTake; j++) {
                if (!symbols.isEmpty()) {
                    builder.append(symbols.get(0));
                    symbols.remove(0);
                }
            }

            for (int j = 0; j < numbersToSkip; j++) {
                if (!symbols.isEmpty())
                    symbols.remove(0);
            }
        }
        System.out.println(builder.toString());
    }
}