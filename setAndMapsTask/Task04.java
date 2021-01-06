package setAndMapsTask;

import java.util.*;

public class Task04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        LinkedHashMap<Character, Integer> lettersByOccurrences = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            if (lettersByOccurrences.isEmpty()) {
                lettersByOccurrences.put(text.charAt(i), 1);
            } else {
                if (lettersByOccurrences.containsKey(text.charAt(i))) {
                    lettersByOccurrences.put(text.charAt(i), lettersByOccurrences.get(text.charAt(i)) + 1);
                } else {
                    lettersByOccurrences.put(text.charAt(i), 1);
                }
            }
        }
        lettersByOccurrences.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.printf("%s: %d time/s%n", e.getKey(), e.getValue()));
    }
}