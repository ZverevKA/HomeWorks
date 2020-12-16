


public class CountThread extends Thread{
    private final long MAX_VAL = 1000000;
    private long x = 0;
    MyCounter counter;
    @Override
    public void run() {
        do {
            x = counter.getAndIncrement();
        } while (x < MAX_VAL);
    }

    public CountThread(MyCounter counter){
        this.counter = counter;
    }

}
