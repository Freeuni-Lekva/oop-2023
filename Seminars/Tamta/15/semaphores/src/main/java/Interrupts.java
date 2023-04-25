import java.util.concurrent.Semaphore;

public class Interrupts {
    public static void main(String[] args) {
        Semaphore arbitrarySem = new Semaphore(0);
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Cycle " + i + "interrupted HEREEEE");
                        return; // დააკომენტარეთ ეს რეთარნი და ნახეთ რა იცვლება
                    }

                    for (int j = 0; j < 100000; j++) {
                        if (j % 10000 == 0) {
                            System.out.println("NOT interrupted");
                        }
                    }

                    // გაუშვით და ნახეთ რა იცვლება
//                    try {
//                        arbitrarySem.acquire();
//                    } catch (InterruptedException e) {
//                        System.out.println("interrupted in TRY CATCH for acquire");
//                        return;
//                    }

                }
            }
        });


        worker.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        worker.interrupt();

    }
}
