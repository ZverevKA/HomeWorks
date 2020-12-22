package Test;

import Main.MyComplex;
import Main.TurtleStep;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
public class SingleThreadTest {
    private TurtleStep[] array;
    private final int sizeOfArray = 1000000;

    @Setup
    public void prepareArray() {
        array = new TurtleStep[sizeOfArray];
        for (int i = 0; i < array.length; i++) {
            array[i] = new TurtleStep((double) (2 * i) % 360, (double) i % 10);
        }
    }
    @Benchmark
    public void prodTest() {
        MyComplex result = TurtleStep.calculateFinalPoint(array);
    }
}