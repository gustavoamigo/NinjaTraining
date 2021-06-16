package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.IntConsumer;

// https://leetcode.com/problems/fizz-buzz-multithreaded/
class FizzBuzz {
    private int n;
    private int currentNumber = 1;

    ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();



    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {

        while(currentNumber <= n) {
            if(currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                printFizz.run();
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while(currentNumber <= n) {
            if(currentNumber % 5 == 0 && currentNumber % 3 != 0) {
                printBuzz.run();
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(currentNumber <= n) {
            if(currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                printFizzBuzz.run();
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(currentNumber <= n) {
            if(currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                printNumber.accept(currentNumber);
                currentNumber++;
                notifyAll();
            }  else {
                wait();
            }

        }
    }
}
