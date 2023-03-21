import java.util.Arrays;

public class BitmaskFilter implements Filter{

    private static final int DEFAULT_SIZE = 2;
    private static final int BLOCK_SIZE = 31;
    private int[] indices;
    private int sz;
    private int actualSize;

    public BitmaskFilter() {
        actualSize = DEFAULT_SIZE;
        indices = new int[DEFAULT_SIZE];
        sz = 0;
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isPresent(int index) {
        int arrIdx = index / BLOCK_SIZE;
        int bitIdx = index % BLOCK_SIZE;
        if (arrIdx < 0 || arrIdx >= actualSize) {
            return false;
        }

        return (indices[arrIdx] & (1<<bitIdx)) > 0;
    }

    @Override
    public void add(int index) {

        if (isPresent(index)) {
            return;
        }
        // Here if the index is less than zero, it will throw exception.

        // Check if we need to resize indices array;
        if (actualSize * BLOCK_SIZE <= index) {
            actualSize = Math.max(index / BLOCK_SIZE + 1 , actualSize * 2);
            indices = Arrays.copyOf(indices , actualSize);
        }

        indices[index / BLOCK_SIZE] |= (1<<(index % BLOCK_SIZE));
        sz++;
    }

    @Override
    public void remove(int index) {
        if (!isPresent(index)) {
            return;
        }

        indices[index / BLOCK_SIZE] ^= (1<<(index % BLOCK_SIZE));
        sz--;
    }
}
