package Test;

import Main.ParallelPrefixScan;
import Main.SingleThreadAlg;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MultithreadedAlgorithmTest {

    static char[] firstArray;
    static char[] secondArray;
    @BeforeClass
    public static void setUp() {
        firstArray = new char[100];
        secondArray = new char[100];
        for (int i = 0; i < firstArray.length; i++) {
            if (i < 50) {
                firstArray[i] = '(';
            }
            else {
                firstArray[i] = ')';
            }
        }
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = '(';
        }
    }
    @Test
    public void firstMultithreadedAlgTest() {
        boolean x,y;
        x = SingleThreadAlg.MatchBrackets(firstArray);
        y = ParallelPrefixScan.doScan(2, firstArray);
        Assert.assertEquals(x, y);
    }
    @Test
    public void secondMultithreadedAlgTest() {
        boolean x, y;
        x = SingleThreadAlg.MatchBrackets(secondArray);
        y = ParallelPrefixScan.doScan(4, secondArray);
        Assert.assertEquals(x, y);
    }
}
