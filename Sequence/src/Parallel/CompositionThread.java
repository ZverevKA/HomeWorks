package Parallel;

public class CompositionThread extends Thread {
    private final int myID;
    private Message msgPool[][];
    private final int procs;
    private Compositionable array[];
    private final int from;
    private final int to;
    private Compositionable total;
    public CompositionThread(int myID, Message[][] msgPool, int procs, Compositionable array[]){
        this.myID = myID;
        this.msgPool = msgPool;
        this.procs = procs;
        this.array = array;
        from = (array.length / procs) * myID;
        if (myID == procs - 1){
            to = array.length;
        }
        else {
            to = (array.length / procs) * (myID + 1);
        }
    }

    public void sendToID(int ID, Compositionable x){
        Message msg = msgPool[ID][myID];
        synchronized (msg){
            msg.setMsg(x);
            msg.setReady();
            msg.notify();
        }
    }
    public Compositionable waitFromID(int ID){
        Message msg = msgPool[myID][ID];
        synchronized (msg){
            while (!msg.isReady()){
                try {
                    msg.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        return msg.getMsg();
    }

    @Override
    public void run() {
        total = array[from];
        for (int i = from + 1; i < to; i++){
            Compositionable composition = (Compositionable) total.composition(total, array[i]);
            total = composition;
        }
        for (int i = 1; i < procs; i *= 2){
            if ((myID & i) != 0){
                sendToID(myID - i, total);
                break;
            }
            else if (myID + i < procs){
                Compositionable composition = (Compositionable) total.composition(total, waitFromID(myID + i));
                total = composition;
            }
        }
        if (myID == 0){
            sendToID(0, total);
        }

    }
}
