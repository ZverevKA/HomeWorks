package Main;

public class PrefixScanThread extends Thread {
    private final int myID;
    private Message msgPool0[][];
    private Message msgPool1[][];
    private final int procs;
    private Carry array[];
    int[] firstN;
    int[] secondN;
    int[] halfResult;
    int[] result;
    private final int from;
    private final int to;
    private Carry total;
    public PrefixScanThread(int myID, Message[][] msgPool0, Message[][] msgPool1, int procs, Carry[] array, int[] firstN, int[] secondN, int[] result) {
        this.myID = myID;
        this.msgPool0 = msgPool0;
        this.msgPool1 = msgPool1;
        this.procs = procs;
        this.array = array;
        this.firstN = firstN;
        this.secondN = secondN;
        this.halfResult = halfResult;
        this.result = result;
        from = (array.length / procs) * myID;
        if (myID == procs - 1) {
            to = array.length;
        }
        else {
            to = (array.length / procs) * (myID + 1);
        }
    }

    public void sendToID(int ID, Carry x, int phase) {
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

    public Carry waitFromID(int ID, int phase) {
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
        total = CarryOp.getIdentityElement();
        for (int i = from; i < to; i++) {
            int y;
            if (i >= firstN.length) {
                y = secondN[i];
            }
            else if (i >= secondN.length) {
                y = firstN[i];
            }
            else {
                y = firstN[i] + secondN[i];
            }
            if (y == 9) {
                array[i] = Carry.M;
            }
            else if (y < 9) {
                array[i] = Carry.N;
            }
            else {
                array[i] = Carry.C;
            }
            Carry composition = CarryOp.composition(total, array[i]);
            total = composition;
        }
        int k;
        for (k = 1; k < procs; k *= 2) {
            if ((myID & k) == 0) {
                sendToID(myID + k, total, 0);
                break;
            }
            else {
                Carry composition = CarryOp.composition(waitFromID(myID - k, 0), total);
                total = composition;
            }
        }
        if (myID == procs - 1) {
            total = CarryOp.getIdentityElement();
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
                Carry t = waitFromID(myID - k, 1);
                sendToID(myID - k, total, 1);
                total = CarryOp.composition(t, total);
            }
            k /= 2;
        }
        for (int i = from; i < to; i++) {
            total = CarryOp.composition(total, array[i]);
            array[i] = total;
            int y;
            if (array[i] == Carry.C) {
                y = 1;
            }
            else {
                y = 0;
            }
            if (i == array.length - 1) {
                result[i + 1] = y;
            }
            else {
                result[i + 1] = (firstN[i + 1] + secondN[i + 1] + y) % 10;
            }
        }
        if (myID == 0) {
            result[0] = (firstN[0] + secondN[0]) % 10;
        }
    }
}