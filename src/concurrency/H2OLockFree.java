package concurrency;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.LockSupport;

public class H2OLockFree {

    ConcurrentLinkedQueue<Runnable> hydrogen = new ConcurrentLinkedQueue<>();
    ConcurrentLinkedQueue<Runnable> oxygen = new ConcurrentLinkedQueue<>();


    public H2OLockFree() {
        new Thread() {
            @Override
            public void run() {
                while(true) {

                }
            }
        }.start();
    }


    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.offer(releaseHydrogen);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.offer(releaseOxygen);
    }

    private void produce() {
        Runnable h1 = null;
        while(h1 == null) {
            h1 = hydrogen.poll();
            if(h1 == null) LockSupport.parkNanos(1L);

        }

        Runnable h2 = null;
        while(h2 == null) {
            h2 = hydrogen.poll();
            if(h2 == null) LockSupport.parkNanos(1L);
        }

        Runnable o = null;
        while( o == null) {
            o = oxygen.poll();
            if(o == null) LockSupport.parkNanos(1L);
        }
        h1.run();
        h2.run();
        o.run();
        LockSupport.parkNanos(1L);
    }

    public static void main(String[] args) throws Throwable {
        H2OLockFree cl = new H2OLockFree();

    }
}
