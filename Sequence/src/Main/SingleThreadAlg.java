package Main;

public class SingleThreadAlg {
    public static long doAlg(Pair[] array) {
        long x = 0;
        for (int i = 0; i < array.length; i++) {
            x = x * array[i].a + array[i].b;
        }
        return x;
    }
}
