import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    @Test
    void add0() {
        assertEquals(5 , Math.add(0,5));
        assertEquals(5 , Math.add(5,0));
    }

    @Test
    void addNegative() {
        assertEquals(-2 , Math.add(-1,-1));
    }

    @Test
    void addPositive() {
        assertEquals(7 , Math.add(3,4));
    }

    @Test
    void addPositiveNegative() {
        assertEquals(0 , Math.add(3,-3));
    }

    @Test
    void addOverflow() {
        assertEquals(Integer.MIN_VALUE , Math.add(Integer.MAX_VALUE,1));
    }


}