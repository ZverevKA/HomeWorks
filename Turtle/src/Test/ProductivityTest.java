package Test;

import Main.MyComplex;
import Main.TurtleStep;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
public class ProductivityTest {
    private TurtleStep[] array;
    private final int sizeOfArray = 1000000;
    @Param({"1", "2", "4"})
    public int numOfThread;

    @Setup
    public void prepareArray(){
        array = new TurtleStep[sizeOfArray];
        for (int i = 0; i < array.length; i++){
            array[i] = new TurtleStep((double) (2 * i) % 360, (double) i % 10);
        }
    }
    @Benchmark
    public void prodTest(){
        MyComplex result = TurtleStep.calculateFinalPoint(array, numOfThread);
    }
}