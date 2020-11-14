package Main;

public class MyCounter {
    private AbstractLock lock;
    private long value;
    public MyCounter(AbstractLock lock){
        this.lock = lock;
        value = 1;
    }
    public long getValue(){
        return value;
    }
    public void increment(){
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
    }
}
