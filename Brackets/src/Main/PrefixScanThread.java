package Main;

import java.util.concurrent.atomic.AtomicBoolean;

public class PrefixScanThread extends Thread {
    private final int myID;
    private Message msgPool0[][];
    private Message msgPool1[][];
    private final int procs;
    private char array[];
    int[] result;
    private final int from;
    private final int to;
    private int total;
    private AtomicBoolean isCorrect;
    public PrefixScanThread(int myID, Message[][] msgPool0, Message[][] msgPool1, int procs, char[] array, int[] result, AtomicBoolean isCorrect) {
        this.myID = myID;
        this.msgPool0 = msgPool0;
        this.msgPool1 = msgPool1;
        this.procs = procs;
        this.array = array;
        this.result = result;
        this.isCorrect = isCorrect;
        from = (array.length / procs) * myID;
        if (myID == procs - 1) {
            to = array.length;
        }
        else {
            to = (array.length / procs) * (myID + 1);
        }
    }
    public int bracketToNumber(char x) {
        if (x == '(') {
            return 1;
        }
        if (x == ')') {
            return -1;
        }
        return 0;
    }

    public void sendToID(int ID, int x, int phase) {
        Message msg = new Message();
        if (phase == 0) {
            msg = msgPool0[ID][myID];
        } else {
            msg = msgPool1[ID][myID];
        }
        synchronized (msg) {
            msg.setMsg(x);
            msg.setReady();
            msg.notify();
        }
    }

    public int waitFromID(int ID, int phase) {
        Message msg = new Message();
        if (phase == 0) {
            msg = msgPool0[myID][ID];
        }
        else {
            msg = msgPool1[myID][ID];
        }
        synchronized (msg) {
            while (!msg.isReady()) {
                try {
                    msg.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return msg.getMsg();
    }

    @Override
    public void run() {
        total = 0;
        for (int i = from; i < to; i++) {
            total += bracketToNumber(array[i]);
        }
        int k;
        for (k = 1; k < procs; k *= 2) {
            if ((myID & k) == 0) {
                sendToID(myID + k, total, 0);
                break;
            }
            else {
                total += waitFromID(myID - k, 0);
            }
        }
        if (myID == procs - 1) {
            total = 0;
        }
        if (k >= procs) {
            k /= 2;
        }
        while (k > 0) {
            if ((myID & k) == 0) {
                sendToID(myID + k, total, 1);
                total = waitFromID(myID + k, 1);
            }
            else {
                int t = waitFromID(myID - k, 1);
                sendToID(myID - k, total, 1);
                total += t;
            }
            k /= 2;
        }
        for (int i = from; i < to; i++) {
            total += bracketToNumber(array[i]);
            result[i] = total;
            if (total < 0) {
                isCorrect.getAndSet(false);
            }
        }
        if ((myID == procs - 1) && (total != 0)) {
            isCorrect.getAndSet(false);
        }
    }
}