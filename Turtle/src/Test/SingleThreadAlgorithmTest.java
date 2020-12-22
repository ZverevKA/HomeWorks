package Test;


import Main.MyComplex;
import Main.TurtleStep;
import org.junit.*;

public class SingleThreadAlgorithmTest {

    static TurtleStep[] firstArray;
    static TurtleStep[] secondArray;
    double delta = 0.1;
    @BeforeClass
    public static void setUp() {
        firstArray = new TurtleStep[8];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = new TurtleStep(90.0, 10.0);
        }
        secondArray = new TurtleStep[6];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = new TurtleStep(120.0,5.0);
        }

    }
    @Test
    public void firstSingleAlgTest() {
        MyComplex x = TurtleStep.calculateFinalPoint(firstArray);
        Assert.assertEquals(0.0, x.getRe(), delta);
        Assert.assertEquals(0.0, x.getIm(), delta);
    }
    @Test
    public void secondSingleAlgTest() {
        MyComplex x = TurtleStep.calculateFinalPoint(secondArray);
        Assert.assertEquals(0.0, x.getRe(), delta);
        Assert.assertEquals(0.0, x.getIm(), delta);
    }
}
