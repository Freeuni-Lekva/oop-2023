import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SumFinder sf = new SumFinder(Arrays.asList(2, 4, 6, 9));
        Integer s = 14;
        Optional<Pair<Integer, Integer>> res = sf.FindSum(s);

        if (res.isPresent()) {
            Pair<Integer, Integer> p = res.get();
            System.out.println(p.getFirst() + " + " + p.getSecond() + " = " + s);
        } else {
            System.out.println("Not found");
        }

    }
}
