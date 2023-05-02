import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 20;
        int m = 20;
        boolean[][] grid = new boolean[n][m];

        initialize(grid);
        Thread[][] cells = new Thread[n][m];

        SwingView swingView = new SwingView(grid);
        ConsoleView consoleView = new ConsoleView(grid);

        CyclicBarrier barrier = new CyclicBarrier(n * m, new Runnable() {
            @Override
            public void run() {
//                System.out.println(Thread.currentThread().getName());

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

                swingView.updateView();
                consoleView.updateView();

            }
        });

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                cells[i][j] = new Thread(new ConwayCell(grid, i, j, 1000, barrier));
                cells[i][j].start();
            }
        }

//        System.out.println("MAIN: " + Thread.currentThread().getName());
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                cells[i][j].join();
            }
        }
//        System.out.println("done");
    }

    public static void initialize(boolean[][] grid) {
        Random r = new Random();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = r.nextBoolean();
            }
        }
    }
}
