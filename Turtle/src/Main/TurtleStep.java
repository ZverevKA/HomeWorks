package Main;

import Parallel.Compositionable;
import Parallel.ConvertableToCompositionable;
import Parallel.ParallelScan;

public class TurtleStep implements ConvertableToCompositionable<TurtleStep, TurtleState> {
    private double angle;         //input data format
    private double distance;

    public TurtleStep(double angel, double distance){
        this.angle = angel;
        this.distance = distance;
    }
    public double getAngle(){
        return angle;
    }
    public double getDistance(){
        return distance;
    }
    @Override
    public Compositionable<TurtleState> ConvertToCompositionable(TurtleStep a) {
        double x = a.getAngle();
        MyComplex y = new MyComplex(a.getDistance(), 0.0);
        return new TurtleState(x, MyComplex.multiplication(MyComplex.getNumberForArg(x), y));
    }
    public static MyComplex calculateFinalPoint(TurtleStep[] array, int procs){
        TurtleState result = (TurtleState) ParallelScan.doScan(array, procs);
        return result.getPoint();
    }
}
