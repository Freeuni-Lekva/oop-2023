import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    final static int BUFFER_SIZE = 10;
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Character> buffer = new ArrayList<>(BUFFER_SIZE);
        Semaphore sem = new Semaphore(0);

        Thread reader = new Thread(new Reader(buffer, sem, BUFFER_SIZE));
        Thread writer = new Thread(new Writer(buffer, sem, BUFFER_SIZE));

        reader.start();
        Thread.sleep(1000);
//        reader.interrupt();
        writer.start();

    }
}
