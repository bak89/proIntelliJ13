package pro13;

import java.util.Arrays;
import java.util.Random;

public class GameLogic {
    private static int[][] RandomArray(int n) {
        int[][] randomMatrix = new int[n][n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                int r = rand.nextInt(5)+1;
                randomMatrix[i][j] = Math.abs(r);
            }

        }

        return randomMatrix;
    }


    public static void main(String[] args) {


        System.out.println(Arrays.deepToString(RandomArray(5)));
    }
}