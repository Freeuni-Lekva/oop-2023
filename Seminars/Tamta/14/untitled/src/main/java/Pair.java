class Pair {
    private int a;
    private int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public synchronized void inc(){
        // R1 = M[SP]
        // R1 = R1 + 1
        // M[SP] = R1
        a++;
        b++;
    }

    public int sum(){
        return a+b;
    }
}

class PairWorker extends Thread{
    private final Pair pair;

    public PairWorker(Pair pair) {
        this.pair = pair;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            pair.inc();
        }
    }
}

class Main_2 {
    public static void main(String[] args) {
        Pair pair = new Pair(0, 0);
        PairWorker p1 = new PairWorker(pair);
        PairWorker p2 = new PairWorker(pair);
        PairWorker p3 = new PairWorker(pair);

        p1.start();
        p2.start();
        p3.start();

        try {
            p1.join();
            p2.join();
            p3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(pair.sum());
    }
}


