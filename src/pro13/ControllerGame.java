package pro13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class ControllerGame implements PropertyChangeListener {

    @FXML
    public AnchorPane anchorPane;

    @FXML
    private Button pause;

    @FXML
    private Button bomb;

    @FXML
    private Button undo;

    public void pause(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ly3.fxml"));
        AnchorPane pane = loader.load();
        anchorPane.getScene().setRoot(pane);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
