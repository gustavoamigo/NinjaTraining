package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class H2ONoWait {

    public H2ONoWait() {

    }

    BlockingDeque<Runnable> hydrogen = new LinkedBlockingDeque<>();
    BlockingDeque<Runnable> oxygen = new LinkedBlockingDeque<>();

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        Runnable h = hydrogen.poll();
        Runnable o = oxygen.poll();
        if(h != null && o != null) {
            h2o(releaseHydrogen, h, o);
        } else {
            hydrogen.offer(releaseHydrogen);
            if(h != null) hydrogen.offer(h);
            if(o != null) oxygen.offer(o);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        Runnable h1 = hydrogen.poll();
        Runnable h2 = hydrogen.poll();
        if(h1 != null && h2 != null) {
            h2o(h1, h2, releaseOxygen);
        } else {
            oxygen.offer(releaseOxygen);
            if(h1 != null) hydrogen.offer(h1);
            if(h2 != null) hydrogen.offer(h2);
        }
    }

    private synchronized void h2o(Runnable h1, Runnable h2, Runnable o) {
        h1.run();
        h2.run();
        o.run();
    }
}
