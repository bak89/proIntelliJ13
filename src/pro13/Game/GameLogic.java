package pro13.Game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Random;

public class GameLogic extends Application {

    private int h;//largest number
    private int lb;//lower bound
    private int ub;//upper bound
    private int w; //max width of range

    public static final int TILE_SIZE = 100;
    public static final int WIDTH = 5;
    public static final int HEIGHT = 5;

    Tile[][] grid = new Tile[WIDTH][HEIGHT];
    private Group tileGroup = new Group();

    private Parent createContent() {
        Pane root = new Pane();

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Tile tile = new Tile( x, y);
                //grid[x][y] = tile;
                tileGroup.getChildren().add(tile);
            }
        }

        root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        root.getChildren().addAll(tileGroup);

        return root;


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());


        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//initialstate
    /*initial state
    lb = 1
    ub = 6

    after each move set
    ub = h-1
    lb = max(1,ub-w)



    //create a 5x5 Matrix
    public static void main( String ... args ){
        int n = 5;
        int[][] randomMatrix = new int[n][n];
        //Block[][] randomMatrix = new Block[n][n];
        Random rand = new Random();

        for (int i = 0; i < randomMatrix.length; i++) {
            for (int j = 0; j < randomMatrix[i].length; j++) {
               randomMatrix[i][j] = rand.nextInt(5) + 1;
              //  randomMatrix[i][j] = new Block();
            }
        }

        for (int[] a : randomMatrix) {
       // for (Block[] a : randomMatrix) {
            System.out.println(Arrays.deepToString(randomMatrix));

        }
    }

    //6 always down

    //connect box with numbers
*/






