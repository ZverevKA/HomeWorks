//General form of counter
public class MyCounter {
    protected long value;
    protected long amount;
    public long getAndIncrement(){
        return value;
    }
    public long getAmount(){
        return amount;
    }
    protected void incrementAmount(){
        amount++;
    }
    public MyCounter(){
        value = 1;
        amount = 0;
    }
    public boolean isPrime(long x) {
        if (x < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(x); i++) {
            if ((x % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
