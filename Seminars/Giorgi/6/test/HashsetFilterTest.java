import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class HashsetFilterTest {

    private Filter filter;
    @BeforeEach
    void setUp() {
        filter = new HashSetFilter();
    }

    @Test
    public void testEmpty() {
        assertEquals(0 , filter.size());
    }

    @Test
    public void testAdd() {
        filter.add(9);
        assertEquals(1 , filter.size());
        assertTrue(filter.isPresent(9));
    }

    @Test
    public void testRemove() {
        filter.add(5);
        assertTrue(filter.isPresent(5));
        filter.remove(5);
        assertFalse(filter.isPresent(5));
        assertEquals(0 , filter.size());
    }

    @Test
    public void testDoubleAdd() {
        filter.add(9);
        filter.add(9);
        assertEquals(1 , filter.size());
        assertTrue(filter.isPresent(9));
    }

    @Test
    public void testDoubleRemove() {
        filter.add(7);
        filter.remove(7);
        filter.remove(7);

        assertFalse(filter.isPresent(7));
        assertEquals(0 , filter.size());
    }

    @Test
    public void loadTest() {
        Instant start = Instant.now();

        int startValue = 1000000000;
        int numElements = 10000000;
        for (int i = startValue; i < startValue + numElements; ++i) {
            filter.add(i);
        }

        assertEquals(numElements , filter.size());

        boolean allEqual = true;
        for (int i = startValue; i < startValue + numElements; i++) {
            allEqual &= filter.isPresent(i);
        }

        // Checks if all of the elements are present in the filter.
        assertTrue(allEqual);

        for (int i = startValue; i < startValue + numElements; ++i) {
            filter.remove(i);
        }

        assertEquals(0, filter.size());

        Instant end = Instant.now();

        assertTrue(end.toEpochMilli() - start.toEpochMilli() <= 1000);
    }
}