import java.util.concurrent.locks.ReentrantLock;

//Counter with lock
public class Counter2 extends MyCounter {
    private final ReentrantLock lock = new ReentrantLock();
    private long temp;

    @Override
    public long getAndIncrement() {
        lock.lock();
        try {
            temp = value;
            if (isPrime(temp)){
                System.out.println(Thread.currentThread().getName() + " " + temp);
                incrementAmount();
            }
            value = value + 1;
        } finally {
            lock.unlock();
        }
        return temp;
    }
}
