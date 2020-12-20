package Main;

public class MyComplex {
    private double re;
    private double im;

    public MyComplex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public static MyComplex sum(MyComplex a, MyComplex b) {
        return new MyComplex(a.re + b.re, a.im + b.im);
    }
    public static MyComplex multiplication(MyComplex a, MyComplex b) {
        return new MyComplex(a.re * b.re - a.im * b.im, a.re * b.im + a.im * b.re);
    }
    public static MyComplex getNumberForArg(double x) {
        return new MyComplex(Math.cos(Math.toRadians(x)), Math.sin(Math.toRadians(x)));
    }
    public double getRe() {
        return re;
    }
    public double getIm() {
        return im;
    }
}
