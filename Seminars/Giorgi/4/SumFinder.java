import java.util.*;

public class SumFinder {
    private final HashMap<Integer, Integer> frequencies;

    SumFinder(Collection<Integer> elements) {
        frequencies = new HashMap<>();
        Iterator<Integer> it = elements.iterator();
        while (it.hasNext()) {
            Integer val = it.next();
            frequencies.put(val, frequencies.getOrDefault(val, 0) + 1);
        }
    }

    // returns the pair of the elements which add up to sum.
    public Optional<Pair<Integer, Integer>> FindSum(Integer sum) {

        if (sum % 2 == 0) {
            Integer half = sum / 2;
            if (frequencies.getOrDefault(half, 0) >= 2) {
                return Optional.of(new Pair(half, half));
            }
        }

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (val * 2 == sum) {
                continue;
            }

            Integer val = entry.getKey();
            // search for sum - val
            if (frequencies.containsKey(sum - val)) {
                return Optional.of(new Pair(val, sum - val));
            }
        }

        return Optional.empty();
    }
}
