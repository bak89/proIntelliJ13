package pro13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;


public class ControllerMenu implements PropertyChangeListener {
    @FXML
    public AnchorPane anchorPane;

    @FXML
    private Button newGame;
    @FXML
    private Button continueGame;
    @FXML
    private Button score;

    @FXML
    private Button language;

    private MenuModel menu;

    public void newGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ly2.fxml"));
        AnchorPane pane = loader.load();
        anchorPane.getScene().setRoot(pane);
    }


    public void continueGame(ActionEvent event) {
    }


    public void score(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ly5.fxml"));
        AnchorPane pane = loader.load();
        anchorPane.getScene().setRoot(pane);
    }

    public void language(ActionEvent event) throws IOException{

    }





    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}






