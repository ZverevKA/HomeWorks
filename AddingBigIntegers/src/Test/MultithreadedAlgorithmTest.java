package Test;

import Main.ParallelPrefixScan;
import Main.SingleThreadAlg;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MultithreadedAlgorithmTest {
    static int[] firstNumber;
    static int[] secondNumber;
    static int[] thirdNumber;

    @BeforeClass
    public static void setUp() {
        firstNumber = new int[100];
        for (int i = 0; i < firstNumber.length; i++) {
            firstNumber[i] = i % 5;
        }
        secondNumber = new int[100];
        for (int i = 0; i < secondNumber.length; i++) {
            secondNumber[i] = i % 9;
        }
        thirdNumber = new int[100];
        for (int i = 0; i < thirdNumber.length; i++) {
            thirdNumber[i] = i % 7;
        }
    }

    @Test
    public void multithreadedAlgTest() {
        Assert.assertArrayEquals(SingleThreadAlg.SumInt(firstNumber, secondNumber), ParallelPrefixScan.doScan(2, firstNumber, secondNumber));
        Assert.assertArrayEquals(SingleThreadAlg.SumInt(firstNumber, thirdNumber), ParallelPrefixScan.doScan(4, firstNumber, thirdNumber));
    }
}
