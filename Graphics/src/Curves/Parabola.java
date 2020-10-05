package Curves;

import java.util.ArrayList;

public class Parabola extends Curve{
    double p;

    public Parabola(double left, double right, double p) {
        super(left, right);
        this.p = p;
        generateEquation();
        graphName = "Parabola";
        this.points = generatePoints();
    }

    public void generateEquation() {
        graphEquation = "2 * "+ Double.toString(p) + " * y = (x^2)" ;
    }

    public ArrayList<Double> getY(double x) {
        ArrayList<Double> Ys = new ArrayList<>();
        Ys.add((x * x) / 2 / p);
        return Ys;
    }


}
