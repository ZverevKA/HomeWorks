package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Curves.Ellipse;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EliController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField aKoef;

    @FXML
    private TextField bKoef;

    @FXML
    private Button OK;
    private Controller controller;


    public EliController(Controller controller) throws IOException {
        this.controller = controller;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ellipse.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage thisStage = new Stage();
        thisStage.setScene(new Scene(root, 350, 250));
        thisStage.setTitle("New ellipse");
        thisStage.show();

    }

    @FXML
    void initialize() {
        OK.setOnAction(actionEvent -> {
            try {
                Ellipse ellipse = new Ellipse(-controller.getMaxBorder(), controller.getMaxBorder(), Double.parseDouble(aKoef.getText()), Double.parseDouble(bKoef.getText()));
                controller.drawNewCurve(ellipse);
                OK.getScene().getWindow().hide();
            } catch (java.lang.NumberFormatException e){
                try {
                    IncorrectInputController inController = new IncorrectInputController();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        });

    }
}
