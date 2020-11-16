package Main;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParallelPrefixScan {
    public static boolean doScan(int procs, char[] array) {   //procs should be power of 2
        Message msgPool0[][] = new Message[procs][procs];
        Message msgPool1[][] = new Message[procs][procs];
        for (int i = 0; i < procs; i++){
            for (int j = 0; j < procs; j++){
                msgPool0[i][j] = new Message();
                msgPool1[i][j] = new Message();
            }
        }
        int[] result = new int[array.length];
        AtomicBoolean isCorrect = new AtomicBoolean(true);
        PrefixScanThread threads[] = new PrefixScanThread[procs];
        for (int i = 0; i < procs; i++){
            threads[i] = new PrefixScanThread(i, msgPool0, msgPool1, procs, array, result, isCorrect);
            threads[i].start();
        }
        for (int i = 0; i < procs; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return isCorrect.get();


    }

}

