package pro13.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import pro13.Game.GameLogic;
import pro13.model.Model;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.Collection;

public class ControllerGame implements PropertyChangeListener {

    @FXML
    public AnchorPane anchorPane;

    @FXML
    private Button pause;

    @FXML
    private Button bomb;

    @FXML
    private Button undo;

    @FXML
    private StackPane stackPane;

    private Model model;


    public void init(Model model) {
        this.model = model;
        this.model.addPropertyChangeListener(this);
    }

    public void pause(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ly3.fxml"));
        AnchorPane pane = loader.load();
        anchorPane.getScene().setRoot(pane);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "New Game":
                stackPane.getChildren().addAll((Group) evt.getNewValue());
                break;
            case "Continue":
                stackPane.getChildren().addAll((Group) evt.getOldValue());
                break;
        }

    }

}
