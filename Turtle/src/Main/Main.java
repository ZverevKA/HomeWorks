package Main;

import Parallel.ParallelScan;

public class Main {

    public static void main(String[] args) {
        TurtleStep steps[] = new TurtleStep[1000000];
        /*for (int i = 0; i < steps.length; i++) {
            steps[i] = new TurtleStep(90.0, 5.0);
        }*/
        for (int i = 0; i < steps.length; i++) {
            steps[i] = new TurtleStep((double) (2 * i) % 360, (double) i % 10);
        }
        MyComplex result = TurtleStep.calculateFinalPoint(steps, 4);
        System.out.println(result.getRe());
        System.out.println(result.getIm());
    }
}
