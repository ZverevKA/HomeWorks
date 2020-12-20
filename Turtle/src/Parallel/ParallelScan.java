package Parallel;

public class ParallelScan {
    public static Compositionable doScan(ConvertableToCompositionable[] array, int procs) {   //procs should be power of 2
        Message msgPool[][] = new Message[procs][procs];
        for (int i = 0; i < procs; i++) {
            for (int j = 0; j < procs; j++) {
                msgPool[i][j] = new Message();
            }
        }
        CompositionThread threads[] = new CompositionThread[procs];
        for (int i = 0; i < procs; i++) {
            threads[i] = new CompositionThread(i, msgPool, procs, array);
            threads[i].start();
        }
        try {
            threads[0].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msgPool[0][0].getMsg();

    }


}
