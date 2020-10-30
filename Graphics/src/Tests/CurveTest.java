package Tests;

import Curves.Curve;
import Curves.Ellipse;
import Curves.Hyperbola;
import Curves.Parabola;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CurveTest {

    private Curve eli, hyp, par;

    @Test
    void getYEllipse() {
        eli = new Ellipse(-30, 30, 10, 15);
        ArrayList<Double> eliPoints1 = eli.getY(0);
        ArrayList<Double> eliPoints2 = eli.getY(10);
        assertEquals(eliPoints1.size(), 2);
        assertEquals(eliPoints2.size(), 1);
        assertEquals(eliPoints1.get(0), 15.0 );
        assertEquals(eliPoints2.get(0), 0.0);
    }
    @Test
    void getYHyperbola(){
        hyp = new Hyperbola(-30, 30, 10, 15);
        ArrayList<Double> hypPoints1 = hyp.getY(0);
        assertEquals(hypPoints1.size(), 2);
        assertEquals(hypPoints1.get(0), 15.0 );
        assertEquals(hypPoints1.get(1), -15.0);
    }
    @Test
    void getYParabola(){
        par = new Parabola(-30, 30, 15);
        ArrayList<Double> parPoints1 = par.getY(0);
        ArrayList<Double> parPoints2 = par.getY(15);
        assertEquals(parPoints1.size(), 1);
        assertEquals(parPoints2.size(), 1);
        assertEquals(parPoints1.get(0), 0.0);
        assertEquals(parPoints2.get(0), 7.5);

    }


}
