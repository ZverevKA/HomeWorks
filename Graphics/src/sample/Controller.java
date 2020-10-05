package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Curves.Curve;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller {

    private Field field;
    private Curves.Curve curve;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane fullPane;

    @FXML
    private Button zoomUpBtn;

    @FXML
    private Button zoomDownBtn;

    @FXML
    private Button eli;

    @FXML
    private Button par;

    @FXML
    private Button hyp;

    @FXML
    private Pane fieldPane;

    @FXML
    private Label equation;

    public void drawNewCurve(Curves.Curve curve){
        this.field.drawGraphic(curve);
        this.curve = curve;
        equation.setText(curve.graphName + " " + curve.graphEquation);
    }
    private void redrawCurve(){
        if (this.curve != null) {
            field.drawGraphic(this.curve);
        }
    }
    public float getMaxBorder(){
        return field.MAX_BORDER;
    }
    @FXML
    void initialize() {
        field = new Field();
        fieldPane.getChildren().add(field);
        field.setPane(fieldPane);
        zoomUpBtn.setOnAction(actionEvent -> {
            field.zoomUp();
            redrawCurve();
        });
        zoomDownBtn.setOnAction(actionEvent -> {
            field.zoomDown();
            redrawCurve();
        });
        par.setOnAction(actionEvent -> {
            try {
                ParController controller2 = new ParController(this);
            } catch (IOException e) {
                e.printStackTrace();
            }


        });
        hyp.setOnAction(actionEvent -> {
            try {
                HypController controller2 = new HypController(this);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        eli.setOnAction(actionEvent -> {
            try {
                EliController controller2 = new EliController(this);
            } catch (IOException e) {
                e.printStackTrace();
            }


        });


    }


}

