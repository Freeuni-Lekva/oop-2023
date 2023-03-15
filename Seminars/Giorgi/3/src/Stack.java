import java.util.Arrays;

public class Stack<T> {

    private Object[] elements;
    int logLen;

    public Stack() {
        elements = new Object[2];
        logLen = 0;
    }

    public void push(T elem) {
        if (logLen == elements.length) {
            elements = Arrays.copyOf(elements, 2 * logLen);
        }

        elements[logLen++] = elem;
    }

    public T pop() {
        if (logLen == 0) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }

        return (T) elements[--logLen];
    }

}
