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
        this.support.firePropertyChange("New Game", null, tiles);
    }

    private void continueWithGame() {
        this.support.firePropertyChange("Continue", tiles, null);
    }

    public void pressButton(int x, int y) {
        ArrayList<Tile> tileArrayList = getNeighborTiles(x, y, new ArrayList<Tile>());
        if (tileArrayList.isEmpty()) {
            return;
        }

        for (Tile tile: tileArrayList) {
            removeBlock(tile);
        }

        getTile(x,y).increaseTile();

    }


    private ArrayList<Tile> getNeighborTiles(int x, int y, ArrayList<Tile> visitedTile) {
        ArrayList<Tile> sameNumber = new ArrayList<>();

        Tile tile = getTile(x, y);

        if (tile == null) {//best case
            return sameNumber;
        }

        visitedTile.add(tile);

        Tile[] tilesNeighbor = new Tile[]{
                getTile(x + 1, y),
                getTile(x - 1, y),
                getTile(x, y + 1),
                getTile(x, y - 1)
        };


        for (Tile neighbor : tilesNeighbor) {
            if (neighbor == null) continue;
            if (tile.getNumber() == neighbor.getNumber() && !visitedTile.contains(neighbor)) {
                sameNumber.add(neighbor);
                sameNumber.addAll(getNeighborTiles(neighbor.getX(), neighbor.getY(), visitedTile));
            }
        }

        return sameNumber;
    }

    private Tile getTile(int x, int y) {
        for (Tile tile : tiles) {
            if (tile.getX() == x && tile.getY() == y) {
                return tile;
            }
        }
        return null;
    }

    private void removeBlock(Tile tile) {
        this.support.firePropertyChange("Remove",null,tile);
    }
}
