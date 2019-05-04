package pro13.Game;

import javafx.scene.control.Button;

/**
 * connette 2 blocchi nel background
 */
public class MergeTile extends Button {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public MergeTile(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

        setPrefSize(Settings.TILE_SIZE, Settings.TILE_SIZE);
        setLayoutX(x1 * Settings.TILE_SIZE);
        setLayoutY(y1 * Settings.TILE_SIZE);

    }
}
