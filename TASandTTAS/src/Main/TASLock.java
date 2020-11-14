package Main;

import java.util.concurrent.atomic.AtomicBoolean;

public class TASLock extends AbstractLock {
    private AtomicBoolean state = new AtomicBoolean(false);

    public void lock(){
        while (state.getAndSet(true)){}
    }

    public void unlock(){
        state.set(false);
    }
}
