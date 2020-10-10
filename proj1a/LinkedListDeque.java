public class LinkedListDeque<T> {
    private final ListNode<T> frontSentinel;
    private final ListNode<T> backSentinel;
    private int size;
    private ListNode<T> list;

    public LinkedListDeque() {
        this.size = 0;
        this.frontSentinel = new ListNode<>(null, null, null);
        this.backSentinel = new ListNode<>(null, null, null);
    }

    /**
     * Adds an item of type T to the front of the deque.
     *
     * @param item Item to add.
     */
    public void addFirst(T item) {
        size += 1;
        if (size == 1) {
            list = new ListNode<>(item, frontSentinel, backSentinel);
        } else {
            list = new ListNode<>(item, frontSentinel, list);
        }
        frontSentinel.next = list;
        list.next.previous = list;
    }

    /**
     * Adds an item of type T to the back of the deque.
     *
     * @param item Item to add.
     */
    public void addLast(T item) {
        size += 1;
        if (size == 1) {
            list = new ListNode<>(item, frontSentinel, backSentinel);
            frontSentinel.next = list;
            backSentinel.previous = list;
        } else {
            // Get the tail and replace it.
            final ListNode<T> tail = backSentinel.previous;
            backSentinel.previous = new ListNode<>(item, tail, backSentinel);
            tail.next = backSentinel.previous;
        }

    }

    /**
     * Returns true if deque is empty, false otherwise.
     *
     * @return If the queue is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the deque.
     *
     * @return Size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first
     * to last, separated by a space.
     */
    public void printDeque() {
        ListNode<T> pointer = list;
        for (int i = 0; i < size; i++) {
            System.out.print(pointer.value);
            // Print space delimiter except the last one.
            if (i != size - 1) System.out.print(" ");
            pointer = pointer.next;
        }
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     *
     * @return First element.
     */
    public T removeFirst() {
        if (size == 0) return null;
        frontSentinel.next = list.next;
        list.next.previous = frontSentinel;
        final T item = list.value;
        list = list.next;
        size -= 1;
        return item;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     *
     * @return Last element.
     */
    public T removeLast() {
        if (size == 0) return null;
        final ListNode<T> tail = backSentinel.previous;
        backSentinel.previous = tail.previous;
        tail.previous.next = backSentinel;
        size -= 1;
        return tail.value;

    }

    /**
     * Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth. If no such item exists,
     * returns null. Must not alter the deque!
     *
     * @param index Index to fetch.
     * @return Item at the given index, if any.
     */
    public T get(int index) {
        if (size == 0 || index >= size) return null;
        ListNode<T> ptr = list;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.value;
    }

    private T getRecursiveHelper(int index, ListNode<T> node) {
        if (size == 0 || index >= size) return null;
        if (index == 0) return node.value;
        return getRecursiveHelper(index - 1, node.next);
    }

    /**
     * Gets the item at a specified index recursively.
     *
     * @param index Index to fetch from.
     * @return Item at the index specified.
     */
    public T getRecursive(int index) {
        return getRecursiveHelper(index, list);
    }
}
