import java.util.Random;

public class SkillBuilder5 {
    private static Random rand = new Random(17);

    public static boolean playCraps() {
        int roll = rollDice();
        if (roll == 7 || roll == 11) {
            return true; // Win
        } else if (roll == 2 || roll == 3 || roll == 12) {
            return false; // Lose
        } else {
            int point = roll;
            while (true) {
                roll = rollDice();
                if (roll == point) {
                    return true; // Win
                } else if (roll == 7) {
                    return false; // Lose
                }
            }
        }
    }

    private static int rollDice() {
        return rand.nextInt(6) + 1 + rand.nextInt(6) + 1; // Simulates rolling two dice
    }

    private static void generateLevel(int level, int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(level * 10); // Generate numbers based on the level
        }
    }

    private static String generateLevelString(int level, int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i < a.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static String pascalsTriangle(int numOfRows) {
        if (numOfRows <= 0) {
            return "";
        }
        
        int[][] triangle = new int[numOfRows][];
        
        for (int i = 0; i < numOfRows; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1; // First element of each row is always 1
            triangle[i][i] = 1; // Last element of each row is always 1
            
            // Fill in the rest of the row
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        // Convert the triangle to a string representation
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j <= i; j++) {
                sb.append(triangle[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString().trim();
    }
}
