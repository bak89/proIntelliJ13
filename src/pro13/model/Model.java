package pro13.model;


import pro13.Game.Settings;
import pro13.Game.Tile;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Model {
    Random random = new Random();
    Tile[][] gridArray = new Tile[Settings.WIDTH][Settings.HEIGHT];
    private PropertyChangeSupport support;

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
                gridArray[x][y] = tile;
            }
        }
        newGame();
    }

    /**
     * Step 4 create meth pressButton
     *
     * @param x
     * @param y
     */
    public void pressButton(int x, int y) {
        System.out.println("x= " + x + " y= " + y);
        ArrayList<Tile> neighbors = getNeighborTiles(x, y, new ArrayList<>());
        if (neighbors.isEmpty()) {
            return;
        }

        for (Tile tile : neighbors) {//qui abbiamo anche i buchi
            removeBlock(tile);
            gridArray[tile.getX()][tile.getY()].setNumber(0);
        }

        getTile(x, y).increaseTile();//from the class tile


         moveTiles();

        //  toTop(getBlocksAsList());

        //mergeWithNewTile(neighbors);

        //print an array in console to check the work
        for (int i = 0; i < Settings.WIDTH; i++) {
            for (int j = 0; j < Settings.HEIGHT; j++) {
                System.out.print(this.gridArray[j][i].getNumber() + " ");
            }
            System.out.println();
        }
    }

    /**
     * Step 2
     * From the first ArrayList Tile tiles , get tile
     *
     * @param x
     * @param y
     * @return
     */
    private Tile getTile(int x, int y) {
        for (Tile tile : getBlocksAsList()) {
            if (tile.getX() == x && tile.getY() == y) {
                return tile;
            }
        }
        return null;
    }


    /**
     * Step 3 create a ArrayList to search neighbor, use method getTile per confrontarli
     *
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

        //search tile neighbor with position recursion
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
     * Step 5
     */
    private void newGame() {
        this.support.firePropertyChange("New Game", null, getBlocksAsList());
    }

    private void continueWithGame() {
        this.support.firePropertyChange("Continue", getBlocksAsList(), null);
    }

    public void removeBlock(Tile tile) {
        this.support.firePropertyChange("Remove", null, tile);
    }

    /**
     * step7
     *
     * @param neighbors
     */
    private void toTop(ArrayList<Tile> neighbors) {

        for (Tile tile : getBlocksAsList()) {
            int y1 = tile.getY() - 1;

            if (getTile(tile.getX(), y1).getNumber() > 0) {
                tile.setNumber(getTile(tile.getX(), y1).getNumber());

            }
        }



       /* for (Tile tile : neighbors) {
            int y = tile.getY();
            for (int i = y; i >= 1; i--) {
//                Tile above = getTile(tile.getX(), i - 1);
                Tile above = getTile(tile.getX(), i );

                gridArray[above.getX()][i - 1] = tile;
                gridArray[above.getX()][i] = above;

                above.fall();
                tile.rise();

                // fallDown(above);
            }
        }*/

    }

    /**
     * Move tiles to the new position
     */
    private void moveTiles() {
        System.out.println("test");
        for (int i = gridArray.length - 1; i >= 0; i--) {
            for (int j = gridArray[i].length - 2; j >= 0; j--) {
                if (gridArray[i][j] != null) {
                    while (gridArray[i][j + 1] == null) {
                        gridArray[i][j].setY(j + 1);
                        gridArray[i][j + 1] = gridArray[i][j];
                        gridArray[i][j] = null;
                        if (j < gridArray[i].length - 2) {
                            j++;
                        }
                    }
                }
            }
        }
    }

    /**
     * Step 8
     *
     * @param tile
     */
    private void fallDown(Tile tile) {
        support.firePropertyChange("Fall", null, tile);
    }

    /**
     * new tile
     */
    private void mergeWithNewTile(ArrayList<Tile> zeroTile) {
        for (Tile tile : zeroTile) {
            int x = tile.getX();
            int y = tile.getY();
            Tile newTile = new Tile(x, y, 0, this);
            this.gridArray[x][y] = newTile;


        }
    }

    /**
     * save what in the array in a list
     */
    private ArrayList<Tile> getBlocksAsList() {

        ArrayList<Tile> blockList = new ArrayList<>();

        for (int i = 0; i < Settings.WIDTH; i++)
            blockList.addAll(Arrays.asList(this.gridArray[i]).subList(0, Settings.HEIGHT));

        return blockList;
    }


    private void bomb(Tile tile) {
        support.firePropertyChange("Bomb", null, tile);
    }
}
