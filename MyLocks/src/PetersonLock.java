public class PetersonLock {
    private volatile boolean[] flag = new boolean[2];
    private volatile int victim;

    public void lock(){
        int id = Integer.parseInt(Thread.currentThread().getName());
        int other = 1 - id;
        victim = id;
        flag[id] = true;
        while (flag[other] && victim == id){}
    }

    public void unlock(){
        int id = Integer.parseInt(Thread.currentThread().getName());
        flag[id] = false;
    }
}
