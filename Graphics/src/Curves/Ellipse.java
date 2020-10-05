package Curves;

import sample.Field;

import java.util.ArrayList;

public class Ellipse extends Curve{

    double a, b, a2, b2;

    public Ellipse(double left, double right, double a, double b) {
        super(left, right);
        this.a = a;
        this.b = b;
        this.a2 = a * a;
        this.b2 = b * b;
        graphName = "Ellipse";
        generateEquation();
        this.points = generatePoints();
    }

    public void generateEquation() {
        graphEquation = "(x^2) / " + Double.toString(a2) + " + (y^2) / " + Double.toString(b2) + " = 1";
    }

    public ArrayList<Double> getY(double x) {
        ArrayList<Double> Ys = new ArrayList<>();
        double y;
        if (1d < (x * x) / a2){
            return Ys;
        }
        if (x == a || x == -a){
            Ys.add((double) 0);
            return Ys;
        }
        else{
            y = Math.sqrt(1 - (x * x) / a2) * b;
            Ys.add(y);
            Ys.add(-y);
            return Ys;
        }
    }


}