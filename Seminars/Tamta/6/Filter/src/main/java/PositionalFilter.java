import java.util.ArrayList;
import java.util.List;

public class PositionalFilter implements Filter {
    private final List<Integer> positions;
    // Rep invariant:
    //   positions[i] < positions[i + 1]
    // Abstraction function:
    //   Represents set of present elements

    public PositionalFilter() {
        positions = new ArrayList<>();
    }

    @Override
    public int size() {
        return positions.size();
    }

    @Override
    public boolean isPresent(int index) {
        // This can be replaced with binary search to improve performance.
        for (int i = 0; i < positions.size(); i++) {
            if (positions.get(i) == index) {
                return true;
            } else if (positions.get(i) > index) {
                break;
            }
        }
        return false;
    }

    @Override
    public void add(int index) {
        for (int i = 0; i < positions.size(); i++) {
            if (positions.get(i) == index) {
                return;
            } else if (positions.get(i) > index) {
                positions.add(i, index);
                return;
            }
        }
        positions.add(index);
    }

    @Override
    public void remove(int index) {
        for (int i = 0; i < positions.size(); i++) {
            if (positions.get(i) == index) {
                positions.remove(i);
                return;
            } else if (positions.get(i) > index) {
                return;
            }
        }
    }
}
