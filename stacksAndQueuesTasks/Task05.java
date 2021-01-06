package stacksAndQueuesTasks;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Task05 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        String[] roboData = in.nextLine().split(";");

        String[] robots = new String[roboData.length];
        int[] wokringTime = new int[roboData.length];
        int[] processTime = new int[roboData.length];

        for (int i = 0; i < roboData.length; i++) {
            robots[i] = roboData[i].split("-")[0];
            wokringTime[i] = Integer.parseInt(roboData[i].split("-")[1]);
            processTime[i] = 0;
        }

        String[] timeData = in.nextLine().split(":");

        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int time = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String> products = new ArrayDeque<>();

        String currentProduct = in.nextLine();

        while (!currentProduct.equals("End")) {
            products.offer(currentProduct);
            currentProduct = in.nextLine();
        }

        while (!products.isEmpty()) {
            time++;

            String product = products.poll();

            boolean isTaken = false;
            for (int i = 0; i < robots.length; i++) {
                if (processTime[i] > 0) {
                    processTime[i]--;
                }
            }

            for (int i = 0; i < robots.length; i++) {

                if (processTime[i] == 0) {
                    int currentH = (time / 3600) % 24;
                    int currentM = (time % 3600) / 60;
                    int currentS = (time % 3600) % 60;
                    System.out.printf("%s - %s [%02d:%02d:%02d]\n", robots[i], product, currentH, currentM, currentS);
                    processTime[i] = wokringTime[i];
                    isTaken = true;
                    break;
                }
            }

            if (!isTaken) {
                products.offer(product);
            }
        }
    }
}