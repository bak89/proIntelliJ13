package pro13.Game;

import java.util.Arrays;
import java.util.Random;

public class GameLogic {

    private int h;//largest number
    private int lb;//lower bound
    private int ub;//upper bound
    private int w; //max width of range


//initialstate
    /*initial state
    lb = 1
    ub = 6

    after each move set
    ub = h-1
    lb = max(1,ub-w)
    */


    //create a 5x5 Matrix
    public static void main( String ... args ){
        int n = 5;
        int[][] randomMatrix = new int[n][n];
        Random rand = new Random();

        for (int i = 0; i < randomMatrix.length; i++) {
            for (int j = 0; j < randomMatrix[i].length; j++) {
                randomMatrix[i][j] = rand.nextInt(5) + 1;
            }
        }

        for (int[] a : randomMatrix) {
            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(a));
        }
    }

    //6 always down

    //connect box with numbers
    public enum tile{
        Yellow,
        Green,
        Brown,
        Red,
        Pink,
        Purple,
        DarkPurple,
        DarkBlue,
        Blue,
        AquaMarine,
        AliceBlue,
        White;
    }

}