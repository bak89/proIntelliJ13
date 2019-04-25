package pro13.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import pro13.model.Model;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class ControllerPause implements PropertyChangeListener {

    @FXML
    public AnchorPane anchorPane;

    @FXML
    private Button continueB;

    @FXML
    private Button restart;

    @FXML
    private Button mainMenu;


    public void restart() throws IOException {
        Model model = new Model();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ly2.fxml"));
        AnchorPane pane = loader.load();
        anchorPane.getScene().setRoot(pane);
        loader.<ControllerGame>getController().init(model);
        model.grid();
    }

    public void mainMenu() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ly1.fxml"));
        AnchorPane pane = loader.load();
        anchorPane.getScene().setRoot(pane);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

