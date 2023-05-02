package ReaderWriter;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Reader implements Runnable{
    private final ArrayList<Character> buffer;
    private final Semaphore sem;
    private final int BUFFER_SIZE;

    public Reader(ArrayList<Character> buffer, Semaphore sem, int BUFFER_SIZE) {
        this.buffer = buffer;
        this.sem = sem;
        this.BUFFER_SIZE = BUFFER_SIZE;
    }
    @Override
    public void run() {
        for (int i = 0; i < BUFFER_SIZE; i++) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("interrupted");
                return;
            }
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(buffer.get(i));
        }

    }
}
