package pro13.Game;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import pro13.Controller.GameController;
import pro13.model.GameModel;
import pro13.model.Model;


public class Tile extends Button {

    private int number;
    private int x;
    private int y;
    private GameModel gameModel;

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

    //public Tile(int x, int y, int number, Model model) {
    public Tile(int x, int y, int number, GameModel gameModel) {
        this.number = number;
        this.x = x;
        this.y = y;

        setPrefSize(Settings.TILE_SIZE, Settings.TILE_SIZE);
        setLayoutX(x * Settings.TILE_SIZE);
        setLayoutY(y * Settings.TILE_SIZE);

        setBackground(new Background(new BackgroundFill(Settings.BLOCK_COLORS.get(number), new CornerRadii(5), Insets.EMPTY)));

        setText(Integer.toString(number));

        setOnAction(event -> {
           // model.pressButton(x, y);
           // gameModel.pressButton(x,y);
        });
    }

    public void increaseTile() {
        number++;
        setText(Integer.toString(number));
        setBackground(new Background(new BackgroundFill(Settings.BLOCK_COLORS.get(number), new CornerRadii(5), Insets.EMPTY)));
    }

    public void setBomb(boolean bomb) {
        if (bomb)
            System.out.println("bomb active");
        else
            System.out.println("bomb not active");
    }

    /**
     * Fall down
     */
    public void fallDown() {
        this.setLayoutY(getLayoutY() + Settings.TILE_SIZE);
    }

    public void rise() {
        y--;
    }

    public void fall() {
        y++;
    }

    public void tileClick() {
        this.gameModel.tileClick(new Location(this.x, this.y));
    }
}
