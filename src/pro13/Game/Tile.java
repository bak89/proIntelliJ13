package pro13.Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.Random;

import static pro13.Game.GameLogic.TILE_SIZE;

public class Tile extends Button {

    private String buttonNumber;
    private int number;
    Random rand = new Random();

    public String getButtonNumber() {
        return buttonNumber;
    }

    public void setButtonNumber(String buttonNumber) {
        this.buttonNumber = buttonNumber;
        int num= rand.nextInt(5) + 1;
        buttonNumber = Integer.toString(num);
    }

    public Tile(int x, int y) {
        this.number = number;
        setPrefSize(TILE_SIZE, TILE_SIZE);
        relocate(x * GameLogic.TILE_SIZE, y * GameLogic.TILE_SIZE);

        int num= rand.nextInt(5) + 1;
        buttonNumber = Integer.toString(num);

        switch (num){
            case 1:
                setText(buttonNumber);
                setStyle("-fx-background-color: #f3ff08");
                break;
            case 2:
                setText(buttonNumber);
                setStyle("-fx-background-color: #19ff00");
                break;
            case 3:
                setText(buttonNumber);
                setStyle("-fx-background-color: #ff9c00");
                break;
            case 4:
                setText(buttonNumber);
                setStyle("-fx-background-color: #ff1100");
                break;
            case 5:
                setText(buttonNumber);
                setStyle("-fx-background-color: #ff0097");
                break;
            case 6:
                setText(buttonNumber);
                setStyle("-fx-background-color: #0037ff");
                break;
            case 7:
                setText(buttonNumber);
                setStyle("-fx-background-color: #f7fcff");
                break;
        }

    /*    setText(buttonNumber);
        setText(getButtonNumber());
        setStyle("-fx-background-color: #ff3b00");
*/
        setOnAction(new pressButton());
    }

    private class pressButton implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String a = increaseTile();
            switch (a){
                case "1":
                    setText(buttonNumber);
                    setStyle("-fx-background-color: #f3ff08");
                    break;
                case "2":
                    setText(buttonNumber);
                    setStyle("-fx-background-color: #19ff00");
                    break;
                case "3":
                    setText(buttonNumber);
                    setStyle("-fx-background-color: #ff9c00");
                    break;
                case "4":
                    setText(buttonNumber);
                    setStyle("-fx-background-color: #ff1100");
                    break;
                case "5":
                    setText(buttonNumber);
                    setStyle("-fx-background-color: #ff0097");
                    break;
                case "6":
                    setText(buttonNumber);
                    setStyle("-fx-background-color: #0037ff");
                    break;
                case "7":
                    setText(buttonNumber);
                    setStyle("-fx-background-color: #f7fcff");
                    break;
            }
            setText(a);

        }

    }

    public String increaseTile() {
        String result;
        int fromButton = Integer.parseInt(getButtonNumber());
        int summe = fromButton + 1;
        return result = Integer.toString(summe);
    }


}
