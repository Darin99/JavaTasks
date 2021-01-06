package setAndMapsTask;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Set<String>> players = new LinkedHashMap<>();
        Map<String, Integer> colorAndPower = new HashMap<>();
        Map<String, Integer> playersTotalPoints = new LinkedHashMap<>();
        colorAndPower.put("S", 4);
        colorAndPower.put("H", 3);
        colorAndPower.put("D", 2);
        colorAndPower.put("C", 1);

        while (!line.equals("JOKER")) {

            String[] nameAndCards = line.split(": ");
            String name = nameAndCards[0];
            String[] cards = nameAndCards[1].split(", ");

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }

            for (String card : cards) {
                players.get(name).add(card);
            }

            line = scanner.nextLine();
        }

        players.forEach((key, value1) -> {

            playersTotalPoints.put(key, 0);

            value1.forEach(y -> {

                Matcher matcher = Pattern.compile("(?<value>\\d+|[JKAQ])(?<color>[SHDC])").matcher(y);

                if (matcher.find()) {
                    String value = matcher.group(1);
                    String color = matcher.group(2);

                    int sum = 0;
                    switch (value) {
                        case "J":
                            sum += 11 * colorAndPower.get(color);
                            break;
                        case "Q":
                            sum += 12 * colorAndPower.get(color);
                            break;
                        case "K":
                            sum += 13 * colorAndPower.get(color);
                            break;
                        case "A":
                            sum += 14 * colorAndPower.get(color);
                            break;
                        default:
                            sum += Integer.parseInt(value) * colorAndPower.get(color);
                            break;
                    }

                    playersTotalPoints.put(key, playersTotalPoints.get(key) + sum);
                }
            });
        });

        playersTotalPoints.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}