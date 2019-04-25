package pro13.model;

import javafx.scene.Group;
import pro13.Game.Settings;
import pro13.Game.Tile;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Random;

public class Model {
    Random random = new Random();

    ArrayList<Tile> tiles = new ArrayList<>();

    private PropertyChangeSupport support;

    private Group tileGroup = new Group();

    public Model() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void grid() {
        for (int x = 0; x < Settings.WIDTH; x++) {
            for (int y = 0; y < Settings.HEIGHT; y++) {
                Tile tile = new Tile(x, y, random.nextInt(5) + 1, this);
                tiles.add(tile);
                tileGroup.getChildren().add(tile);
            }
        }
        newGame();
    }

    private void newGame() {
        this.support.firePropertyChange("New Game", null, tileGroup);
    }

    private void continueWithGame(){
        this.support.firePropertyChange("Continue",tileGroup,null);
    }

    public void pressButton(int x, int y) {


    }


    private ArrayList<Tile> getNeighborTiles(int x, int y, ArrayList<Tile> oldTile) {
        Tile[] tiles = new Tile[]{
                getTile(x + 1, y),
                getTile(x - 1, y),
                getTile(x, y + 1),
                getTile(x, y - 1)
        };

        return null;
    }

    private Tile getTile(int x, int y) {
        for (Tile tile : tiles) {
            if (tile.getX() == x && tile.getY() == y) {
                return tile;
            }
        }
        return null;
    }
}
