package Main;

import Parallel.Compositionable;

public class TurtleState implements Compositionable<TurtleState> {
    private double direction;    // angel of view
    private MyComplex point;    // point on complex coordinate system
    public TurtleState(double direction, MyComplex point){
        this.direction = direction;
        this.point = point;
    }
    public double getDirection(){
        return direction;
    }
    public MyComplex getPoint(){
        return point;
    }

    @Override
    public TurtleState composition(TurtleState a, TurtleState b) {
        double newDirection = a.direction + b.direction;
        if (newDirection >= 360.0){
            newDirection -= 360.0;
        }
        MyComplex newPoint = MyComplex.sum(a.point, MyComplex.multiplication(b.point, MyComplex.getNumberForArg(a.direction)));
        return new TurtleState(newDirection, newPoint);
    }
}
