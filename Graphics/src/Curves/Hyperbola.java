package Curves;

import java.util.ArrayList;

public class Hyperbola extends Curve{
    double a, b, a2, b2;

    public Hyperbola(double left, double right, double a, double b) {
        super(left, right);
        this.a = a;
        this.b = b;
        this.a2 = a * a;
        this.b2 = b * b;
        graphName = "Hyperbola";
        generateEquation();
        this.points = generatePoints();
    }

    public void generateEquation() {
        graphEquation = "(y^2) / " + Double.toString(b2) + " - (x^2) / " + Double.toString(a2) + " = 1";
    }

    public ArrayList<Double> getY(double x) {
        ArrayList<Double> Ys = new ArrayList<>();
        double y;
        y = Math.sqrt(1 + (x * x / a2)) * b;
        Ys.add(y);
        Ys.add(-y);
        return Ys;
    }


}
