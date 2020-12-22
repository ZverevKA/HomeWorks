package Test;

import Main.Pair;
import Main.SingleThreadAlg;
import Parallel.ParallelScan;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MultithreadedAlgorithmTest {
    static Pair[] firstArray;
    static Pair[] secondArray;
    @BeforeClass
    public static void setUp() {
        firstArray = new Pair[100];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = new Pair(i % 2, i % 3);
        }
        secondArray = new Pair[100];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = new Pair(i % 3, i % 7);
        }
    }

    @Test
    public void multithreadedAlgTest() {
        Pair x, y;
        x = (Pair) ParallelScan.doScan(firstArray, 2);
        y = (Pair) ParallelScan.doScan(secondArray, 4);
        Assert.assertEquals(SingleThreadAlg.doAlg(firstArray), x.b);
        Assert.assertEquals(SingleThreadAlg.doAlg(secondArray), y.b);
    }
}
