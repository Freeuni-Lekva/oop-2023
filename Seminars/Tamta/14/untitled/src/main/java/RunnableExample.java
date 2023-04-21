public class RunnableExample implements Runnable{

    @Override
    public void run() {
        System.out.println("\nRunnable Task");
        System.out.println(Thread.currentThread().getName());
    }
}

class Main {
    public static void main(String[] args) {
        Runnable task = new RunnableExample();
        Thread th1 = new Thread(task, "thread1");
        Thread th2 = new Thread(task, "thread2");
        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("\nAnonymous Runnable Thread");
            }
        });

        th1.start();
        th2.start();
        th3.start();

        try {
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


