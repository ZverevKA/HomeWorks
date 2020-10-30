package sample;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IncorrectInputController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button OKbutton;

    public IncorrectInputController() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Incorrect.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage thisStage = new Stage();
        thisStage.setScene(new Scene(root, 300, 120));
        thisStage.setTitle("Error!");
        thisStage.show();

    }
    @FXML
    void initialize() {
        OKbutton.setOnAction(ActionEvent -> {
            OKbutton.getScene().getWindow().hide();
        });

    }
}

