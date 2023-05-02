import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<T> {
    private ArrayList<T> queue;
    private final int MAX_SIZE;
    ReentrantLock lock;
    Condition enqueueCond;
    Condition dequeueCond;


    public MyBlockingQueue(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        queue = new ArrayList<>();
    }

    public void enqueue(T elem) throws InterruptedException {
        lock.lock();
        while (queue.size() == MAX_SIZE) {
            enqueueCond.await();
        }
        queue.add(elem);
        dequeueCond.signal();
        lock.unlock();
    }

    public void dequeue() throws InterruptedException {
        lock.lock();
        while (queue.size() == 0) {
            dequeueCond.await();
        }
        queue.remove(0);
        enqueueCond.signal();
        lock.unlock();
    }

    public T tryDequeue(int time) throws InterruptedException {
        lock.lock();
        boolean elapsed;
        while (queue.size() == 0) {
             elapsed = dequeueCond.await(time, TimeUnit.SECONDS);
             if (!elapsed) {
                 lock.unlock();
                 return null;
             }
        }
        T elem = queue.remove(0);
        enqueueCond.signal();
        lock.unlock();

        return elem;
    }

    public void tryEnqueue(T elem, int time) throws InterruptedException {
        lock.lock();
        while (queue.size() == MAX_SIZE) {
            boolean elapsed = enqueueCond.await(time, TimeUnit.SECONDS);
            if (!elapsed) {
                lock.unlock();
                return;
            }
        }
        queue.add(elem);
        dequeueCond.signal();
        lock.unlock();
    }
}
