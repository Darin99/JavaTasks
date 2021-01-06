package matrixTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task08 {

    private static final String CLOUD_SPELL = "Cloud";
    private static final int CLOUD_SPELL_DMG = 3500;
    private static final String ERUPTION_SPELL = "Eruption";
    private static final int ERUPTION_SPELL_DMG = 6000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double dmgDealtToBoss = Double.parseDouble(reader.readLine());

        int fieldSize = 15;
        int[][] field = new int[fieldSize][fieldSize];

        int playerHealth = 18500;
        double bossHealth = 3000000;

        int[] playerPosition = new int[2];

        playerPosition[0] = 7;
        playerPosition[1] = 7;

        boolean cloudIsActive = false;
        boolean heroIsAlive = true;

        StringBuilder report;
        StringBuilder bossStatus = new StringBuilder("Heigan: ");
        StringBuilder playerStatus = new StringBuilder("Player: ");
        StringBuilder finalPosition = new StringBuilder("Final position: ");

        while (true) {

            if (!heroIsAlive) {
                break;
            }

            bossHealth -= dmgDealtToBoss;

            if (cloudIsActive) {
                cloudIsActive = false;
                playerHealth -= CLOUD_SPELL_DMG;
                if (playerHealth <= 0) {
                    playerStatus.append("Killed by ").append("Plague ").append(CLOUD_SPELL);
                    finalPosition.append(playerPosition[0]).append(", ").append(playerPosition[1]);
                    if (bossHealth <= 0) {
                        bossStatus.append("Defeated!");
                    }
                    break;
                }
            }

            if (bossHealth <= 0) {
                bossStatus.append("Defeated!");
                break;
            }

            String[] bossAttackData = reader.readLine().split("\\s+");
            String spell = bossAttackData[0];
            int row = Integer.parseInt(bossAttackData[1]);
            int col = Integer.parseInt(bossAttackData[2]);

            switch (spell) {

                case CLOUD_SPELL:

                    markAttackedZones(fieldSize, field, row, col, CLOUD_SPELL_DMG);

                    if (field[playerPosition[0]][playerPosition[1]] == CLOUD_SPELL_DMG) {

                        boolean escaped = tryToEscape(field, playerPosition, playerPosition[0], playerPosition[1]);

                        if (!escaped) {

                            playerHealth -= CLOUD_SPELL_DMG;
                            cloudIsActive = true;
                            if (playerHealth <= 0) {
                                playerStatus.append("Killed by ").append("Plague ").append(CLOUD_SPELL);
                                finalPosition.append(playerPosition[0]).append(", ").append(playerPosition[1]);
                                heroIsAlive = false;
                            }
                        }
                    }

                    clearField(field);
                    break;
                case ERUPTION_SPELL:

                    markAttackedZones(fieldSize, field, row, col, ERUPTION_SPELL_DMG);


                    if (field[playerPosition[0]][playerPosition[1]] != 0) {

                        boolean escaped = tryToEscape(field, playerPosition, playerPosition[0], playerPosition[1]);

                        if (!escaped) {

                            if (field[playerPosition[0]][playerPosition[1]] != 0) {

                                playerHealth -= ERUPTION_SPELL_DMG;
                                if (playerHealth <= 0) {
                                    playerStatus.append("Killed by ").append(ERUPTION_SPELL);
                                    finalPosition.append(playerPosition[0]).append(", ").append(playerPosition[1]);
                                    heroIsAlive = false;
                                }
                            }
                        }
                    }

                    clearField(field);
                    break;
            }
        }

        if (bossHealth <= 0 && playerHealth <= 0) {
            report = bossStatus.append(System.lineSeparator()).append(playerStatus).append(System.lineSeparator())
                    .append(finalPosition);
            System.out.println(report.toString());
        } else if (bossHealth > 0) {
            bossStatus.append(String.format("%.2f", bossHealth));
            report = bossStatus.append(System.lineSeparator()).append(playerStatus).append(System.lineSeparator())
                    .append(finalPosition);
            System.out.println(report.toString());
        } else {
            playerStatus.append(playerHealth);
            finalPosition.append(playerPosition[0]).append(", ")
                    .append(playerPosition[1]);
            report = bossStatus.append(System.lineSeparator()).append(playerStatus).append(System.lineSeparator())
                    .append(finalPosition);
            System.out.println(report.toString());
        }
    }

    private static boolean tryToEscape(int[][] field, int[] playerPosition, int playerRow, int playerCol) {

        if (isValidPosition(field, playerRow - 1, playerCol)) {
            playerPosition[0] = playerRow - 1;
            return true;
        }


        if (isValidPosition(field, playerRow, playerCol + 1)) {
            playerPosition[1] = playerCol + 1;
            return true;
        }


        if (isValidPosition(field, playerRow + 1, playerCol)) {
            playerPosition[0] = playerRow + 1;
            return true;
        }


        if (isValidPosition(field, playerRow, playerCol - 1)) {
            playerPosition[1] = playerCol - 1;
            return true;
        }

        return false;
    }

    private static void clearField(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 0;
            }
        }
    }

    private static boolean isValidPosition(int[][] field, int x, int y) {

        return x >= 0 && x < field.length && y >= 0 && y < field.length && field[x][y] == 0;
    }

    private static void markAttackedZones(int fieldSize, int[][] field, int row, int col, int dmg) {
        if (row == 0 && col == 0) {

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    field[i][j] += dmg;
                }
            }

        } else if (row == 0 && col == field[0].length - 1) {

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    field[i][field[i].length - 1 - j] += dmg;
                }
            }

        } else if (row == fieldSize - 1 && col == 0) {

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    field[fieldSize - 1 - i][j] += dmg;
                }
            }

        } else if (row == fieldSize - 1 && col == fieldSize - 1) {

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    field[fieldSize - 1 - i][fieldSize - 1 - j] += dmg;
                }
            }

        } else if (row == 0 && col > 0 && col < fieldSize - 1) {

            field[row][col] += dmg;
            field[row][col + 1] += dmg;
            field[row][col - 1] += dmg;
            field[row + 1][col] += dmg;
            field[row + 1][col + 1] += dmg;
            field[row + 1][col - 1] += dmg;

        } else if (row == fieldSize - 1 && col > 0 && col < fieldSize - 1) {

            field[row][col - 1] += dmg;
            field[row][col] += dmg;
            field[row][col + 1] += dmg;
            field[row - 1][col - 1] += dmg;
            field[row - 1][col] += dmg;
            field[row - 1][col + 1] += dmg;

        } else if (col == 0 && row > 0 && row < fieldSize - 1) {

            field[row][col] += dmg;
            field[row - 1][col] += dmg;
            field[row - 1][col + 1] += dmg;
            field[row][col + 1] += dmg;
            field[row + 1][col] += dmg;
            field[row + 1][col + 1] += dmg;

        } else if (col == fieldSize - 1 && row > 0 && row < fieldSize - 1) {

            field[row][col] += dmg;
            field[row - 1][col] += dmg;
            field[row - 1][col - 1] += dmg;
            field[row][col - 1] += dmg;
            field[row + 1][col - 1] += dmg;
            field[row + 1][col] += dmg;

        } else if (col == -1 && row == -1) {

            field[0][0] += dmg;

        } else if (col == -1 && row == fieldSize) {

            field[fieldSize - 1][0] += dmg;

        } else if (row == -1 && col == fieldSize) {

            field[0][fieldSize - 1] += dmg;


        } else if (row == fieldSize && col == fieldSize) {

            field[fieldSize - 1][fieldSize - 1] += dmg;

        } else if (col == -1 && row > 0 && row < fieldSize - 1) {

            field[row - 1][col + 1] += dmg;
            field[row][col + 1] += dmg;
            field[row + 1][col + 1] += dmg;


        } else if (row == -1 && col > 0 && col < fieldSize - 1) {

            field[row + 1][col - 1] += dmg;
            field[row + 1][col] += dmg;
            field[row + 1][col + 1] += dmg;

        } else if (col == fieldSize && row > 0 && row < fieldSize - 1) {

            field[row][col - 1] += dmg;
            field[row - 1][col - 1] += dmg;
            field[row + 1][col - 1] += dmg;


        } else if (row == fieldSize && col > 0 && col < fieldSize - 1) {

            field[row - 1][col] += dmg;
            field[row - 1][col - 1] += dmg;
            field[row - 1][col + 1] += dmg;


        } else if (row == 0 && col == -1) {

            field[row][col + 1] += dmg;
            field[row + 1][col + 1] += dmg;

        } else if (row == -1 && col == 0) {

            field[row + 1][col] += dmg;
            field[row + 1][col + 1] += dmg;


        } else if (row == -1 && col == fieldSize - 1) {

            field[row + 1][col] += dmg;
            field[row + 1][col - 1] += dmg;


        } else if (row == 0 && col == fieldSize) {

            field[row][col - 1] += dmg;
            field[row + 1][col - 1] += dmg;

        } else if (row == fieldSize - 1 && col == -1) {

            field[row][col + 1] += dmg;
            field[row - 1][col + 1] += dmg;

        } else if (row == fieldSize && col == 0) {

            field[row - 1][col] += dmg;
            field[row - 1][col + 1] += dmg;

        } else if (row == fieldSize && col == fieldSize - 1) {
            field[row - 1][col] += dmg;
            field[row - 1][col - 1] += dmg;


        } else if (row == fieldSize - 1 && col == fieldSize) {
            field[row][col - 1] += dmg;
            field[row - 1][col - 1] += dmg;

        } else if (row > 0 && row < fieldSize - 1 && col > 0 && col < fieldSize - 1) {

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    field[row - 1 + i][col - 1 + j] += dmg;
                }
            }
        }
    }
}
