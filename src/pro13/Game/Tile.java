package pro13.Game;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.Random;

import static pro13.Game.GameLogic.TILE_SIZE;

public class Tile extends Button {


    private String buttonNumber = "2";
    private int number;

    public Tile(int x, int y) {
        this.number = number;
        setPrefSize(TILE_SIZE, TILE_SIZE);
        relocate(x * GameLogic.TILE_SIZE, y * GameLogic.TILE_SIZE);
        //Random rand = new Random();
        //Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
        setStyle("-fx-background-color: #ff3b00");
        setText(buttonNumber);
        setOnAction(e -> {
           String a = increaseTile();
           setText(a);
            setStyle("-fx-background-color: #69ff1c");


        });
    }

    public String increaseTile() {
        String result;

        int fromButton = Integer.parseInt(buttonNumber);

        int summe = fromButton + 1;
        return result = Integer.toString(summe);
    }
}
