//Counter with my Peterson lock
public class Counter3 extends MyCounter {
    private final PetersonLock lock = new PetersonLock();
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
