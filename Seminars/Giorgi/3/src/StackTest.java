import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {


    @Test
    void testCreate() {
        Stack<Integer> st = new Stack<>();
    }

    @Test
    void testEmpty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Stack st = new Stack<>();
            st.pop();
        });
    }

    @Test
    void testOneElement() {
        Stack<String> st = new Stack<String>();
        String elem = new String("element");
        st.push(elem);
        assertEquals(elem, st.pop());
    }

    @Test
    void testDifferentTypes() {
        Stack st = new Stack();
        String stringElem = new String("element");
        Integer intElem = 10;

        st.push(stringElem);
        st.push(intElem);

        assertEquals(intElem, st.pop());
        assertEquals(stringElem, st.pop());
    }

    @Test
    void testAddMany() {
        Stack <Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);

        assertEquals(3, st.pop());
        assertEquals(2, st.pop());
        assertEquals(1, st.pop());
    }

}