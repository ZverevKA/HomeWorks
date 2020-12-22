package Main;

import Parallel.ParallelScan;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Pair array[] = new Pair[262144];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = new Pair(2, 0);
        }
        Pair result = (Pair) ParallelScan.doScan(array, 8);
        System.out.println(result.b);
    }
}
