package Main;

public class CountThread extends Thread {
    public final long MAX_VALUE = 1000000;
    public MyCounter counter;
    public CountThread(MyCounter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        do {
            counter.increment();
        } while (counter.getValue() < MAX_VALUE);
    }
}
