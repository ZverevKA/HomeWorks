package Test;

import Main.SingleThreadAlg;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SingleThreadAlgorithmTest {
    static int[] firstNumber;
    static int[] secondNumber;
    static int[] thirdNumber;
    static int[] firstResult;
    static int[] secondResult;
    @BeforeClass
    public static void setUp() {
        firstNumber = new int[100];
        for (int i = 0; i < firstNumber.length; i++) {
            firstNumber[i] = 4;
        }
        secondNumber = new int[100];
        for (int i = 0; i < secondNumber.length; i++) {
            secondNumber[i] = 5;
        }
        secondNumber[0] = 6;
        thirdNumber = new int[100];
        for (int i = 0; i < thirdNumber.length; i++) {
            thirdNumber[i] = 3;
        }
        firstResult = new int[101];
        for (int i = 0; i < firstNumber.length - 1; i++) {
            firstResult[i] = 0;
        }
        firstResult[firstResult.length - 1] = 1;
        secondResult = new int[101];
        for (int i = 0; i < secondResult.length - 1; i++) {
            secondResult[i] = 7;
        }
        secondResult[secondResult.length - 1] = 0;

    }

    @Test
    public void singleAlgTest() {
        Assert.assertArrayEquals(firstResult, SingleThreadAlg.SumInt(firstNumber, secondNumber));
        Assert.assertArrayEquals(secondResult, SingleThreadAlg.SumInt(firstNumber, thirdNumber));
    }
}
