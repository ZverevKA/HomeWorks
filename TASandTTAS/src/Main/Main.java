package Main;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyCounter counter = new MyCounter(new TTASLock());
        CountThread threads[] = new CountThread[16];
        for (int i = 0; i < threads.length; i++){
            threads[i] = new CountThread(counter);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++){
            threads[i].join();
        }
    }
}
