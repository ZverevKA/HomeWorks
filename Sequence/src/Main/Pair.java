package Main;

import Parallel.Compositionable;

public class Pair implements Compositionable<Pair> {

    public long a;
    public long b;
    public Pair(){
        this.a = 0;
        this.b = 0;
    }
    public Pair(long a, long b){
        this.a = a;
        this.b = b;
    }

    // result of composition is pairResult.b
    @Override
    public Pair composition(Pair a, Pair b) {
        long x = a.a * b.a;
        long y = a.b * b.a + b.b;
        return new Pair(x, y);
    }
}