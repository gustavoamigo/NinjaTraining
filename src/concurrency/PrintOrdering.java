package concurrency;

import java.util.concurrent.CountDownLatch;

/*
https://leetcode.com/problems/print-in-order/
 */
public class PrintOrdering {
    class Foo {

        private boolean first = false;
        private boolean second = false;

        public Foo() {

        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            first = true;
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while(!first) {
                wait(1000);
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            second = true;
            notifyAll();

        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            while(!second) {
                wait(1000);
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

        }
    }

    public static void main(String[] args) {
    }
}
