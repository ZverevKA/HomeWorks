package Curves;

import javafx.geometry.Point2D;

import java.util.ArrayList;

public abstract class Curve {

    public final double epsilon = 0.00000001;
    protected ArrayList<Point2D>[] points;
    public String graphName;
    public String graphEquation;
    public abstract ArrayList<Double> getY(double x);
    public abstract void generateEquation();
    public final double DIST = (double) 1 / 10000;
    public double left, right;
    public Curve(double left, double right){
        this.left = left;
        this.right = right;
    }


    public ArrayList<Point2D>[] generatePoints(){
        double step = (right - left) * DIST;
        ArrayList<Point2D> first = new ArrayList<>();
        ArrayList<Point2D> second = new ArrayList<>();
        ArrayList<Point2D> third = new ArrayList<>();
        ArrayList<Point2D> fourth = new ArrayList<>();
        for (double k = left; k <= right; k+= step){
            ArrayList<Double> Ys = getY(k);
            for (Double y: Ys){
                if (y > left && y < right){
                    if (k >= 0 && y >= 0){
                        first.add(new Point2D(k, y));
                    }
                    if (k <= 0 && y >= 0){ //tut
                        second.add(new Point2D(k, y));
                    }
                    if (k <= 0 && y <= 0) {
                        third.add(new Point2D(k, y));
                    }
                    if (k >= 0 && y <= 0){ //tut
                        fourth.add(new Point2D(k, y));
                    }
                }
            }
        }
        return new ArrayList[]{first, second, third, fourth};
    }

    public ArrayList<Point2D>[] getPoints(){
        return points;
    }

}
