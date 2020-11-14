// Counter without any locks
public class Counter1 extends MyCounter {
    @Override
    public long getAndIncrement() {
        long temp = value;
        if (isPrime(temp)){
            System.out.println(Thread.currentThread().getName() + " " + temp);
            incrementAmount();
        }
        value = value + 1;
        return temp;
    }

}