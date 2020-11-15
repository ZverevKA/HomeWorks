package Test;

import Main.Pair;
import Main.SingleThreadAlg;
import Parallel.ParallelScan;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
public class ProductivityTest {
    private Pair[] array;
    private final int sizeOfArray = 1000000;
    @Param({"1", "2", "4"})
    public int numOfThread;

    @Setup
    public void prepareArray(){
        array = new Pair[sizeOfArray];
        for (int i = 0; i < array.length; i++){
            array[i] = new Pair(i % 5, i % 17);
        }
    }
    @Benchmark
    public void prodTest(){
        Pair result = (Pair) ParallelScan.doScan(array, numOfThread);
    }
    @Benchmark
    public void singleThreadTest(){
        long result = SingleThreadAlg.doAlg(array);
    }


}
