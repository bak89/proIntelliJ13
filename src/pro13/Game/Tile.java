package pro13.Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import pro13.model.Model;


public class Tile extends Button {


    private int number;
    private int x;
    private int y;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tile(int x, int y, int number, Model model) {
        this.number = number;
        this.x = x;
        this.y = y;

        setPrefSize(Settings.TILE_SIZE, Settings.TILE_SIZE);
        setLayoutX(x * Settings.TILE_SIZE);
        setLayoutY(y * Settings.TILE_SIZE);

        setBackground(new Background(new BackgroundFill(Settings.BLOCK_COLORS.get(number), new CornerRadii(5), Insets.EMPTY)));

        setText(Integer.toString(number));

        setOnAction(event -> {
            model.pressButton(x, y);
        });


    }


    public void increaseTile() {
        number++;
        setText(Integer.toString(number));
        setBackground(new Background(new BackgroundFill(Settings.BLOCK_COLORS.get(number), new CornerRadii(5), Insets.EMPTY)));
    }

    /**
     * Fall down
     */
    public void fallDown(){
        this.setLayoutY(getLayoutY()+Settings.TILE_SIZE);
    }


    public void rise(){
        y--;
    }

    public void fall(){
        y++;
    }
}
