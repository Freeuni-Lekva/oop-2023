import java.util.HashSet;

public class HashSetFilter implements Filter{

    private HashSet<Integer> indices;

    public HashSetFilter() {
        indices = new HashSet<>();
    }

    @Override
    public int size() {
        return indices.size();
    }

    @Override
    public boolean isPresent(int index) {
        return indices.contains(index);
    }

    @Override
    public void add(int index) {
        indices.add(index);
    }

    @Override
    public void remove(int index) {
        indices.remove(index);
    }
}
