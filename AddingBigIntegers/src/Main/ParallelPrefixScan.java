package Main;

public class ParallelPrefixScan {
    public static int[] doScan(int procs, int[] firstN, int[] secondN) {   //procs should be power of 2
        Message msgPool0[][] = new Message[procs][procs];
        Message msgPool1[][] = new Message[procs][procs];
        for (int i = 0; i < procs; i++) {
            for (int j = 0; j < procs; j++) {
                msgPool0[i][j] = new Message();
                msgPool1[i][j] = new Message();
            }
        }
        int[] result = new int[Math.max(firstN.length, secondN.length) + 1];
        Carry[] array = new Carry[result.length - 1];
        PrefixScanThread threads[] = new PrefixScanThread[procs];
        for (int i = 0; i < procs; i++) {
            threads[i] = new PrefixScanThread(i, msgPool0, msgPool1, procs, array, firstN, secondN, result);
            threads[i].start();
        }
        for (int i = 0; i < procs; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /*for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }*/
        return result;

    }

}

