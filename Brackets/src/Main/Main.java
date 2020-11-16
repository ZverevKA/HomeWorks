package Main;

public class Main {

    public static void main(String[] args) {
        char[] array = new char[1024];
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) ('(' + (i % 2));
        }
        System.out.println(ParallelPrefixScan.doScan(4, array));
        System.out.println(SingleThreadAlg.MatchBrackets(array));

    }
}
