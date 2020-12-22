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
    private final int sizeOfArray = 100000;
    private int[] firstN = new int[sizeOfArray];
    private int[] secondN = new int[sizeOfArray];
    @Param({"1", "2", "4"})
    public int numOfThread;

    @Setup
    public void prepareArray() {
        for (int i = 0; i < firstN.length; i++) {
            firstN[i] = i % 9 + 1;
            secondN[i] = i % 8 + 1;
        }
    }
    @Benchmark
    public void prodTest() {
        ParallelPrefixScan.doScan(numOfThread, firstN, secondN);
    }
    @Benchmark
    public void singleThreadTest() {
        SingleThreadAlg.SumInt(firstN, secondN);
    }


}