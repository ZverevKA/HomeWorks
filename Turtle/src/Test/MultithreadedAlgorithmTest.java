package Test;

import Main.MyComplex;
import Main.TurtleStep;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MultithreadedAlgorithmTest {

    static TurtleStep[] firstArray;
    static TurtleStep[] secondArray;
    double delta = 0.1;
    @BeforeClass
    public static void setUp() {
        firstArray = new TurtleStep[100];
        secondArray = new TurtleStep[100];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = new TurtleStep((double) (2 * i) % 360, (double) i % 10);
        }
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = new TurtleStep((double) (3 * i) % 360, 7.0);
        }
    }
    @Test
    public void firstMultithreadedAlgTest() {
        MyComplex x,y;
        x = TurtleStep.calculateFinalPoint(firstArray);
        y = TurtleStep.calculateFinalPoint(firstArray, 2);
        Assert.assertEquals(x.getRe(), y.getRe(), delta);
        Assert.assertEquals(x.getRe(),y.getRe(),delta);
    }
    @Test
    public void secondMultithreadedAlgTest() {
        MyComplex x,y;
        x = TurtleStep.calculateFinalPoint(secondArray);
        y = TurtleStep.calculateFinalPoint(secondArray, 4);
        Assert.assertEquals(x.getRe(), y.getRe(), delta);
        Assert.assertEquals(x.getRe(),y.getRe(),delta);
    }
}
