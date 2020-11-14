public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyCounter counter = new Counter1();
        CountThread []threads = new CountThread[2];
        for (int i = 0; i < threads.length; i++){
            threads[i] = new CountThread(counter);
            threads[i].setName(Integer.toString(i));
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++){
            threads[i].join();
        }

        System.out.println(counter.getAmount());


    }
}
