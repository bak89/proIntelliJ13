package pro13;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

    //aggiunta lingua
       // ResourceBundle bundle = ResourceBundle.getBundle("easter.example", new Locale("de", "DE"));


        Parent root = FXMLLoader.load(getClass().getResource("Controller/ly1.fxml")); //bun
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root, 386, 653));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
