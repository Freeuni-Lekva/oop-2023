import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilterTest {

    private Filter filter;
    @Before
    public void init(){
        filter = new BitmaskFilter();
    } // ახლა იტესტება BitmaskFilter იმპლემენტაცია. სხვა იმპლემენტციის გასატესტად ჩაანაცვლეთ ინიციალიზაცია new BooleanArrayFilter ან სხვა კლასით.
        // ან გადააკოპირეთ ეს ტესტ კლასი და შეცვალეთ მხოლოდ ინიტ ფუნქციაში დაინიცალიზებული კლასი

    @Test
    public void testIsPresent(){
        filter.add(0);
        filter.add(17);
        filter.add(31);
        assertTrue(filter.isPresent(17));
        assertTrue(filter.isPresent(0));
    }

    @Test
    public void addRemove() {
        assertFalse(filter.isPresent(0));
        filter.add(0);
        assertTrue(filter.isPresent(0));
        filter.remove(0);
        assertFalse(filter.isPresent(0));
    }

    @Test
    public void emptyPresence() {
        assertEquals(0, filter.size());
        for (int i = 0; i < 5; i++) {
            assertFalse(filter.isPresent(i));
        }
    }

    @Test
    public void addEvenIndexes() {
        for (int i = 0; i < 100; i += 2) {
            assertFalse(filter.isPresent(i));
            filter.add(i);
            assertTrue(filter.isPresent(i));
        }
        for (int i = 1; i < 100; i += 2) {
            assertFalse(filter.isPresent(i));
        }
    }
}
