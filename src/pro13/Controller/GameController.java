package pro13.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import pro13.Game.MergeTile;
import pro13.Game.Settings;
import pro13.Game.Tile;
import pro13.model.GameModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameController implements PropertyChangeListener {

    @FXML
    public AnchorPane boardGame;
    @FXML
    private StackPane stackPane;
    @FXML
    private Button pause;
    @FXML
    private Button bomb;
    @FXML
    private Button undo;
    @FXML
    private Label RecordPoint;
    @FXML
    private Label RecordLevel;


    private GameModel gameModel;
    private ArrayList<Tile> tile;
    private ArrayList<MergeTile> mergeTiles;


    Random random = new Random();
    Tile[][] gridArray = new Tile[Settings.WIDTH][Settings.HEIGHT];


    public void init(GameModel gameModel) {
        this.gameModel = gameModel;
        this.gameModel.addPropertyChangeListener(this);
    }

    public void addBoardGame() throws IOException {
        this.mergeTiles = new ArrayList<>();

        //pause menu
        FXMLLoader pauseLoader = new FXMLLoader(getClass().getResource("ly3.fxml"));
        AnchorPane pausePane = pauseLoader.load();
        boardGame.getScene().setRoot(pausePane);

        //game over
        FXMLLoader gameOverLoader = new FXMLLoader(getClass().getResource("ly4.fxml"));
        AnchorPane gameOverPane = gameOverLoader.load();
        boardGame.getScene().setRoot(gameOverPane);

        //click event
        this.pause.setOnAction(event -> this.pauseGame());
        this.bomb.setOnAction(event -> this.bomb());
        this.undo.setOnAction(event -> this.undo());
    }

    private void undo() {

    }

    private void bomb() {
    }

    private void pauseGame() {

    }

    public void grid() {
        for (int x = 0; x < Settings.WIDTH; x++) {
            for (int y = 0; y < Settings.HEIGHT; y++) {
                Tile tile = new Tile(x, y, random.nextInt(5) + 1, gameModel);
                gridArray[x][y] = tile;
            }
        }
    }

    public ArrayList<Tile> getBlocksAsList() {
        ArrayList<Tile> blockList = new ArrayList<>();
        for (int i = 0; i < Settings.WIDTH; i++)
            blockList.addAll(Arrays.asList(this.gridArray[i]).subList(0, Settings.HEIGHT));
        return blockList;
    }

    private Tile getTile(int x, int y) {
        for (Tile tile : getBlocksAsList()) {
            if (tile.getX() == x && tile.getY() == y) {
                return tile;
            }
        }
        return null;
    }

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

    public void pressButton(int x, int y) {
        System.out.println("x= " + x + " y= " + y);
        ArrayList<Tile> neighbors = getNeighborTiles(x, y, new ArrayList<>());
        if (neighbors.isEmpty()) {
            return;
        }

        for (Tile tile : neighbors) {//qui abbiamo anche i buchi
            gameModel.removeBlock(tile);
            gridArray[tile.getX()][tile.getY()].setNumber(0);
        }

        getTile(x, y).increaseTile();//from the class tile


        //  moveTiles();

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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case GameModel.createTile:
                getBlocksAsList();
                break;
            case GameModel.continueWithGame:
                break;
            case GameModel.removeTile:
                break;
            case GameModel.tileClick:
                break;
            case GameModel.gameOver:
                break;
        }
    }
}
