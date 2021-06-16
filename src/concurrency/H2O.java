package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class H2O {

    final ReentrantLock lock;
    private final Condition hydrogenReleased;
    private final Condition oxygenReleased;

    public H2O() {
        lock = new ReentrantLock();
        hydrogenReleased = lock.newCondition();
        oxygenReleased = lock.newCondition();
    }

    int h = 0;

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try {
            while(h>=2) oxygenReleased.await();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            h++;
            hydrogenReleased.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while(h<2) hydrogenReleased.await();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            h-=2;
            oxygenReleased.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
