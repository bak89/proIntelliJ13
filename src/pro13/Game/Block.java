package pro13.Game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Block extends Application {



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test 2 Rettangle");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250, Color.BLUE);


        Rectangle white = new Rectangle();
        white.setWidth(100);
        white.setHeight(100);
        white.setFill(Color.WHITE);

        Rectangle red = new Rectangle();
        red.setWidth(100);
        red.setHeight(100);
        red.setFill(Color.RED);

        Rectangle black = new Rectangle();
        black.setWidth(100);
        black.setHeight(100);
        black.setFill(Color.BLACK);

        Rectangle purple = new Rectangle();
        purple.setWidth(100);
        purple.setHeight(100);
        purple.setFill(Color.PURPLE);

        GridPane gridPane = new GridPane();
        gridPane.add(white,0,0);
        gridPane.add(black,1,0);
        gridPane.add(red,0,1);
        gridPane.add(purple,1,1);




        root.getChildren().addAll(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}