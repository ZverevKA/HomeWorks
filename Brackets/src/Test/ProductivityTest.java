package Test;

import Main.ParallelPrefixScan;
import Main.SingleThreadAlg;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
public class ProductivityTest {
    private char[] array;
    private final int sizeOfArray = 1000000;
    @Param({"1", "2", "4"})
    public int numOfThread;

    @Setup
    public void prepareArray(){
        array = new char[sizeOfArray];
        for (int i = 0; i < array.length; i++){
            array[i] = (char) ('(' + (i % 2));
        }
    }
    @Benchmark
    public void prodTest(){
        boolean result = ParallelPrefixScan.doScan(numOfThread, array);
    }
    @Benchmark
    public void singleThreadTest(){
        boolean result = SingleThreadAlg.MatchBrackets(array);
    }


}