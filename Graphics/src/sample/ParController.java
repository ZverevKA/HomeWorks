package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Curves.Ellipse;
import Curves.Parabola;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ParController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField pKoef;

    @FXML
    private Button OK;
    public final Controller controller;

    public ParController(Controller controller) throws IOException {
        this.controller = controller;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Parabola.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage thisStage = new Stage();
        thisStage.setScene(new Scene(root, 350, 250));
        thisStage.setTitle("New parabola");
        thisStage.show();

    }

    @FXML
    void initialize() {
        OK.setOnAction(actionEvent -> {
            Parabola parabola = new Parabola(-controller.getMaxBorder(), controller.getMaxBorder(), Double.parseDouble(pKoef.getText()));
            controller.drawNewCurve(parabola);
            OK.getScene().getWindow().hide();
        });
    }
}