import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinkedListDequeJUnitTest {
    private LinkedListDeque<Integer> deque;

    @Before
    public void setUp() throws Exception {
        deque = new LinkedListDeque<>();
    }

    @Test
    public void addFirst() {
        deque.addFirst(5);
        int first = deque.removeFirst();
        assertEquals(5, first);
    }

    @Test
    public void addLast() {
        deque.addLast(5);
        int last = deque.removeLast();
        assertEquals(5, last);
    }

    @Test
    public void isEmpty() {
        assertTrue(deque.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(0, deque.size());
        deque.addLast(5);
        assertEquals(1, deque.size());
    }

    @Test
    public void printDeque() {
        deque.addFirst(1);
        deque.addFirst(0);
        deque.addLast(2);
        deque.printDeque();
    }

    @Test
    public void removeFirst() {
        deque.addLast(1);
        int first = deque.removeFirst();
        assertEquals(1, first);
    }

    @Test
    public void removeLast() {
        deque.addFirst(10);
        int last = deque.removeLast();
        assertEquals(10, last);
    }

    @Test
    public void get() {
        deque.addFirst(1);
        deque.addFirst(0);
        deque.addLast(2);
        deque.addLast(3);
        int zero = deque.get(0);
        assertEquals(0, zero);
        int last = deque.get(3);
        assertEquals(3, last);
    }

    @Test
    public void getRecursive() {
        deque.addFirst(1);
        deque.addFirst(0);
        deque.addLast(2);
        deque.addLast(3);
        int zero = deque.getRecursive(0);
        assertEquals(0, zero);
        int last = deque.getRecursive(3);
        assertEquals(3, last);
        assertEquals(1, (int) deque.get(1));
    }
}