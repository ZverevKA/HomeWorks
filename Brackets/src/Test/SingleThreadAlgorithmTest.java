package Test;

import Main.ParallelPrefixScan;
import Main.SingleThreadAlg;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SingleThreadAlgorithmTest {
    static char[] firstArray;
    static char[] secondArray;
    @BeforeClass
    public static void setUp() {
        firstArray = new char[100];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = (char)('(' + (i % 2));
        }
        secondArray = new char[100];
        for (int i = 0; i < secondArray.length; i++) {
            if ((i % 4) < 2) {
                secondArray[i] = '(';
            }
            else {
                secondArray[i] = ')';
            }
        }
    }

    @Test
    public void singleAlgTest() {
        Assert.assertEquals(true, SingleThreadAlg.MatchBrackets(firstArray));
        Assert.assertEquals(true, SingleThreadAlg.MatchBrackets(secondArray));
    }
}
