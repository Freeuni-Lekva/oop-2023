package ReaderWriter;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Writer implements Runnable{
    private final ArrayList<Character> buffer;
    private final Semaphore sem;
    private final int BUFFER_SIZE;

    public Writer(ArrayList<Character> buffer, Semaphore sem, int BUFFER_SIZE) {
        this.buffer = buffer;
        this.sem = sem;
        this.BUFFER_SIZE = BUFFER_SIZE;
    }
    @Override
    public void run() {
        for (int i = 0; i < BUFFER_SIZE; i++) {
            Character x = (char) ('a' + i);
            buffer.add(x);
            System.out.println("added " + x);
            sem.release();
        }
    }
}
