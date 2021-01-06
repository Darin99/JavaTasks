package setAndMapsTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isTrue = false;
        Map<String, Integer> keyRegands = new HashMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();

        keyRegands.put("fragments", 0);
        keyRegands.put("shards", 0);
        keyRegands.put("motes", 0);

        while (!isTrue) {

            String[] materials = scanner.nextLine().split("\\s+");

            for (int i = 0; i < materials.length - 1; i += 2) {

                int quantity = Integer.parseInt(materials[i]);
                String material = materials[i + 1].toLowerCase();

                if (material.equals("fragments") || material.equals("shards") || material.equals("motes")) {
                    keyRegands.put(material, keyRegands.get(material) + quantity);

                    if (keyRegands.get(material) >= 250) {

                        keyRegands.put(material, keyRegands.get(material) - 250);
                        isTrue = true;

                        if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");

                        } else if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");

                        } else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        break;
                    }
                } else {

                    if (!junk.containsKey(material)) {
                        junk.put(material, quantity);
                    } else {
                        junk.put(material, junk.get(material) + quantity);
                    }
                }
            }
        }

        keyRegands.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
