package Test;

import Main.Pair;
import Main.SingleThreadAlg;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SingleThreadAlgorithmTest {
    static Pair[] firstArray;
    static Pair[] secondArray;
    @BeforeClass
    public static void setUp() {
        firstArray = new Pair[10];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = new Pair(1, 1);
        }
        secondArray = new Pair[10];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = new Pair(2, 2);
        }
    }

    @Test
    public void singleAlgTest() {
        Assert.assertEquals(10, SingleThreadAlg.doAlg(firstArray));
        Assert.assertEquals(2046, SingleThreadAlg.doAlg(secondArray));
    }
}
