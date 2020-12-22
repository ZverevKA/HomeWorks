package Main;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = new int[10];
        for (int i = 0; i < a.length; i ++) {
            a[i] = 4;
            b[i] = 5;
        }
        b[0] = 6;
        //ParallelPrefixScan.doScan(4, a, b);
        int[] result = SingleThreadAlg.SumInt(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
