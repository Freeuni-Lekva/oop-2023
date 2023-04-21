public class FirstWorker extends Thread{

    public FirstWorker(String name) {
       super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            if(i % 100_000 == 0) {
                System.out.println(i);
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}

class Main_1 {
    public static void main(String[] args) {
        FirstWorker w1 = new FirstWorker("FirstWorker 1");
        FirstWorker w2 = new FirstWorker("FirstWorker 2");

        w1.start();
        w2.start();

        try {
            w1.join();
            w2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
