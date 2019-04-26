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

    /**
     * Step 1 Create a grid
     */
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

    /**
     * Step 5
     */
    private void newGame() {
        this.support.firePropertyChange("New Game", null, tiles);
    }

    private void continueWithGame() {
        this.support.firePropertyChange("Continue", tiles, null);
    }

    /**
     * Step 4 create meth pressButton
     * @param x
     * @param y
     */
    public void pressButton(int x, int y) {
        ArrayList<Tile> neighbors = getNeighborTiles(x, y, new ArrayList<Tile>());
        if (neighbors.isEmpty()) {
            return;
        }

        for (Tile tile : neighbors) {//qui abbiamo anche i buchi
            removeBlock(tile);
        }

        getTile(x, y).increaseTile();//from the class tile

    }

    /**
     * Step 3 create a ArrayList to search neighbor, use method getTile per confrontarli
     * @param x
     * @param y
     * @param visitedTile
     * @return
     */
    private ArrayList<Tile> getNeighborTiles(int x, int y, ArrayList<Tile> visitedTile) {
        ArrayList<Tile> sameNumber = new ArrayList<>();

        Tile tile = getTile(x, y);

        if (tile == null) {//best case
            return sameNumber;
        }

        visitedTile.add(tile);

        //search tile neighbor with position
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

    /**
     * Step 2
     * From the first ArrayList Tile tiles , get tile
     * @param x
     * @param y
     * @return
     */
    private Tile getTile(int x, int y) {
        for (Tile tile : tiles) {
            if (tile.getX() == x && tile.getY() == y) {
                return tile;
            }
        }
        return null;
    }

    private void removeBlock(Tile tile) {
        this.support.firePropertyChange("Remove", null, tile);
    }

    /**
     * step6
     *
     * @param neighbors
     */
    private void toTop(ArrayList<Tile> neighbors) {

        for (Tile tile : neighbors) {
            int y = tile.getY();
            for (int i = y; i >= 1; i--) {
                Tile above =getTile(tile.getX(),i - 1);
                above.setY(above.getY()+1);
                tile.setY(tile.getY()-1);
                fallDown(above);
            }
        }

    }

    /**
     * Step 7
     * @param tile
     */
    private void fallDown(Tile tile){
        support.firePropertyChange("Fall",null,tile);
    }
}
