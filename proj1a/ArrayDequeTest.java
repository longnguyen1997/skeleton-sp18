import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayDequeTest {
    ArrayDeque<Integer> deque;

    @Before
    public void setUp() {
        deque = new ArrayDeque<>();
    }

    @Test
    public void addFirst() {
        deque.addFirst(10);
        final int first = 10;
        assertEquals(10, first);
    }

    @Test
    public void addLast() {
        deque.addLast(5);
        final int last = deque.removeLast();
        assertEquals(5, last);
    }

    @Test
    public void get() {
        deque.addFirst(0);
        deque.addLast(10);
        deque.addLast(11);
        deque.addFirst(12);
        final int tail = deque.get(3);
        assertEquals(11, tail);
        final int head = deque.get(0);
        assertEquals(12, head);
        assertEquals(4, deque.size());
    }

    @Test
    public void printDeque() {
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.printDeque();
    }

    @Test
    public void removeFirst() {
        deque.addFirst(5);
        final int last = deque.removeFirst();
        assertEquals(5, last);
        assertEquals(0, deque.size());
    }

    @Test
    public void removeLast() {
        deque.addFirst(5);
        final int last = deque.removeLast();
        assertEquals(5, last);
        assertEquals(0, deque.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(deque.isEmpty());
    }

    @Test
    public void size() {
        deque.addFirst(5);
        deque.addLast(10);
        assertEquals(2, deque.size());
    }

    @Test
    public void resize() {
        for (int i = 0; i < 10000; i++) {
            deque.addFirst(i);
            final int head = deque.get(0);
            assertEquals(i, head);
        }
        for (int i = 0; i < 9999; i++) {
            deque.removeLast();
        }
    }
}