import java.util.concurrent.CyclicBarrier;

public class ConwayCell implements Runnable{
    private boolean[][] grid;
    private int x;
    private int y;
    private int numIterations;
    private CyclicBarrier barrier;

    public ConwayCell(boolean[][] grid, int x, int y, int numIterations, CyclicBarrier barrier) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.numIterations = numIterations;
        this.barrier = barrier;
    }

    private boolean getNextState(){
        int aliveCount = 0;

        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (x + i >= 0 && x + i < grid.length
                        && y + j >= 0 && y + j < grid[0].length ) {
                    if (grid[x + i][y + j] && !(i == 0 && j == 0)) {
                        aliveCount++;
                    }
                }
            }
        }

        boolean isAlive = grid[x][y];
        boolean nextState = isAlive;

        if (isAlive) {
            if (aliveCount < 2 || aliveCount > 3) {
                nextState = false;
            }
        } else {
            if (aliveCount == 3) {
                nextState = true;
            }
        }

        return nextState;
    }
    @Override
    public void run() {
        for (int iteration = 0; iteration < numIterations; iteration++){
//            System.out.println("Thread name: " + Thread.currentThread().getName());
            boolean nextState = getNextState();
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            grid[x][y] = nextState;
        }
    }
}
