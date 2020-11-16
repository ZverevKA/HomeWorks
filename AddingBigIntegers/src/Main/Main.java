package Main;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[1000000];
        int[] b = new int[1000000];
        for (int i = 0; i < a.length; i ++) {
            a[i] = i % 9 + 1;
            b[i] = i % 8 + 1;
        }
        ParallelPrefixScan.doScan(4, a, b);
    }
}
