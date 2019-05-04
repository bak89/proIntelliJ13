package pro13.model;

import pro13.Controller.TileMatrix;
import pro13.Game.Location;
import pro13.Game.Tile;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class GameModel {
    private PropertyChangeSupport support;
    public static final String createTile = "Create Tile";
    public static final String createMergeTile = "Create Merge Tile";
    public static final String continueWithGame = "Continue";
    public static final String tileClick = "Tile Click";
    public static final String removeTile = "Remove Tile";
    public static final String gameOver = "Game Over";



    public GameModel() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void createTile(ArrayList<Tile> listNewTile){
        support.firePropertyChange(createTile, null,listNewTile);
    }
    public void tileClick(Location location) {
        support.firePropertyChange(tileClick, null, location);
    }
    public void createMergeTile(ArrayList<TileMatrix> mergeTileCreate) {

        support.firePropertyChange(createMergeTile, null, mergeTileCreate);
    }
    public void removeBlock(Tile tile) {
        support.firePropertyChange(removeTile, null, tile);
    }
}

