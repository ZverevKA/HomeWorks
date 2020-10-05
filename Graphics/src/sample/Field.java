package sample;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

import java.util.ArrayList;

public class Field extends Canvas {



    public final int WIDTH = 500;
    public final int HEIGHT = 500;
    public final int DEFAULT_PIX_SIZE =  5;
    private Point2D zeroPoint;
    private final float zoomK = 10f;
    private int [] zoomAr = {10, 15, 20, 30, 50};
    private int zoomNumb;
    private int zoom;
    private final int NUMB_QUANTITY = 5;
    private final int STEP = WIDTH / (NUMB_QUANTITY * 2);
    private float leftBorder, rightBorder;
    public final float MAX_BORDER;
    private Pane pane;
    public Polyline[] polylines;
    public Polyline polylineabc;
    public boolean isEmpty[] = {true, true, true, true};

    public void setPane(Pane pane) {
        this.pane = pane;
    }
    public void zoomUp(){
        if (zoomNumb < (zoomAr.length - 1)){
            zoomNumb++;
            zoom = zoomAr[zoomNumb];
            updateBorders();
        }
    }
    public void zoomDown(){
        if (zoomNumb > 0){
            zoomNumb--;
            zoom = zoomAr[zoomNumb];
            updateBorders();
        }
    }

    public void updateBorders(){
        leftBorder = -WIDTH / zoom * zoomK / DEFAULT_PIX_SIZE / 2;
        rightBorder = -leftBorder;
    }

    public Field() {
        setWidth(WIDTH);
        setHeight(HEIGHT);
        polylines = new Polyline[4];
        zoomNumb = 0;
        zoom = zoomAr[zoomNumb];
        MAX_BORDER = WIDTH / DEFAULT_PIX_SIZE /zoom * zoomK / 2;
        zeroPoint = new Point2D(getWidth() / 2, getHeight() / 2);
        updateBorders();
        drawZero();
        drawCoordSystem();
        drawX();
        drawY();
    }


    public void tryToDraw(){
        Polyline abc = new Polyline();
        abc.getPoints().addAll(zeroPoint.getX(), zeroPoint.getY(), zeroPoint.getX() + 100, zeroPoint.getY() + 100);
        pane.getChildren().add(abc);
    }

    private void drawZero(){
        GraphicsContext zero = getGraphicsContext2D();
        zero.setFill(Color.BLACK);
       // zero.fillOval(zeroPoint.getX(), zeroPoint.getY(), 50, 50);
        zero.fillText("0", zeroPoint.getX() + 5, zeroPoint.getY() + 15);
    }

    private void drawCoordSystem(){
        GraphicsContext coord = getGraphicsContext2D();
        drawZero();;
        coord.setLineWidth(2);
        coord.strokeLine(0, zeroPoint.getY(), getWidth(), zeroPoint.getY());
        coord.strokeLine(zeroPoint.getX(), 0, zeroPoint.getX(), getHeight());
    }

    private void drawX(){
        GraphicsContext oX = getGraphicsContext2D();
        float n;
        for (int i = 1; i <= NUMB_QUANTITY; i++){
            n = (zoomK / zoom) * STEP * i / DEFAULT_PIX_SIZE;
            oX.fillText(String.format("%.1f", n), zeroPoint.getX() + i * STEP - 10, zeroPoint.getY() + 15 );
            oX.fillText(String.format("%.1f", -n), zeroPoint.getX() - i * STEP - 10, zeroPoint.getY() + 15 );
        }
    }
    private void drawY(){
        GraphicsContext oY = getGraphicsContext2D();
        float n;
        for (int i = 1; i <= NUMB_QUANTITY; i++){
            n = (zoomK / zoom) * STEP * i / DEFAULT_PIX_SIZE;
            oY.fillText(String.format("%.1f", n), zeroPoint.getX() - 30, zeroPoint.getY() + STEP * i );
            oY.fillText(String.format("%.1f", -n), zeroPoint.getX() - 30, zeroPoint.getY() - STEP * i);
        }
    }

    public void drawCurve(Curves.Curve curve) {
        double koef = zoom / zoomK * DEFAULT_PIX_SIZE;
        ArrayList<Point2D>[] points = curve.getPoints();
        for (int i = 0; i < points.length; i++) {
            Polyline polyline = new Polyline();
            for (Point2D point : points[i]) {
                if (isOnField(point)) {
                    isEmpty[i] = false;
                    polyline.getPoints().add(zeroPoint.getX() + point.getX() * koef);
                    polyline.getPoints().add(zeroPoint.getY() - point.getY() * koef);
                }
                polyline.setStroke(Color.RED);
                polylines[i] = polyline;
            }
        }
    }
    public void drawGraphic(Curves.Curve curve){
        deleteGraphic();
        drawCoordSystem();
        drawZero();
        //tryToDraw();
        drawX();
        drawY();
        drawCurve(curve);
        for (int i = 0; i < 4; i++){
            if (!isEmpty[i]) {
                pane.getChildren().add(polylines[i]);
            }
        }
    }

    public void deleteGraphic() {
        for (int i = 0; i < 4; i++){
            if (!isEmpty[i]){
                pane.getChildren().remove(polylines[i]);
                polylines[i].getPoints().clear();
            }
            isEmpty[i] = true;
        }
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());
    }

    public boolean isOnField(Point2D point){
        if (point.getX() > leftBorder && point.getX() < rightBorder && point.getY() > leftBorder & point.getY() < rightBorder) {
            return true;
        }
        return false;
        }

}


