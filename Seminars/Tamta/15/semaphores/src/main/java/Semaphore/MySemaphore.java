package Semaphore;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MySemaphore {
    private int permits;
    ReentrantLock lock;
    Condition condition;

    public MySemaphore(int permits){
        this.permits = permits;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void acquire() throws InterruptedException {
        lock.lock();
        while (permits == 0) {
            condition.await();
        }
        permits--;
        lock.unlock();
    }

    public void release(){
        lock.lock();
        permits++;
        condition.signal();
        lock.unlock();
    }
}
