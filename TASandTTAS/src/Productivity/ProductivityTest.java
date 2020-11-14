package Productivity;

import Main.*;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(value = 2)
public class ProductivityTest {
    private MyCounter TASCounter;
    private MyCounter TTASCounter;
    private Thread[] TASThreads;
    private Thread[] TTASThreads;


    @Param({"1", "2", "4", "8", "16", "32", "64"})
    public int numOfThread;

    @Benchmark
    public void TASTest() throws InterruptedException{
        TASCounter = new MyCounter(new TASLock());
        TASThreads = new Thread[numOfThread];
        for (int i = 0; i < numOfThread; i++){
            TASThreads[i] = new CountThread(TASCounter);
            TASThreads[i].start();
        }
        for (int i = 0; i < numOfThread; i++){
            TASThreads[i].join();
        }

    }
    @Benchmark
    public void TTASTest() throws InterruptedException{
        TTASCounter = new MyCounter(new TTASLock());
        TTASThreads = new Thread[numOfThread];
        for (int i = 0; i < numOfThread; i++){
            TTASThreads[i] = new CountThread(TTASCounter);
            TTASThreads[i].start();
        }
        for (int i = 0; i < numOfThread; i++){
            TTASThreads[i].join();
        }
    }

}

