public class ArrayDeque<T> {
    T[] items;
    int size;
    int nextHead;
    int nextTail;

    public ArrayDeque() {
        this.items = (T[]) new Object[8];
        nextHead = 0;
        nextTail = 1;
        size = 0;
    }

    private int mod(int index) {
        int a, b;
        a = index;
        b = items.length;
        return (a % b + b) % b;
    }

    private void resize() {
        // Defensive programming.
        if (size == 0) return;
        // If bigger than size 16, must always be at least 25% utilized.
        if (items.length >= 16 && ((float) size) / items.length < 0.25) {
            System.out.println("Below utilization. Halving from " + items.length + ".");
            halfSize();
        }
        // No more capacity.
        if (size == items.length) {
            System.out.println("Maxed out. Doubling from " + items.length + ".");
            doubleSize();
        }
    }

    private void copyToContainer(T[] container) {
        for (int i = 0; i < size; i++) {
            container[i] = items[mod(nextHead + 1 + i)];
        }
        nextHead = container.length - 1;
        nextTail = size;
        items = container;
    }

    private void doubleSize() {
        T[] newContainer = (T[]) new Object[items.length * 2];
        copyToContainer(newContainer);

    }

    private void halfSize() {
        T[] newContainer = (T[]) new Object[items.length / 2];
        copyToContainer(newContainer);
    }

    public void addFirst(T item) {
        resize();
        size += 1;
        items[nextHead] = item;
        nextHead = mod(nextHead - 1);
    }

    public void addLast(T item) {
        resize();
        size += 1;
        items[nextTail] = item;
        nextTail = mod(nextTail + 1);
    }

    public T get(int index) {
        if (size == 0 || index >= size) return null;
        // Get to the current head.
        int i = mod(nextHead + 1);
        for (int j = 0; j < index; j++) {
            i = mod(i + 1);
        }
        return items[i];
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[mod(nextHead + 1 + i)]);
            if (i != size - 1) System.out.print(" ");
        }
    }

    public T removeFirst() {
        if (size == 0) return null;
        size -= 1;
        // Move the pointer back by 1.
        nextHead = mod(nextHead + 1);
        resize();
        // Pointer location is now the first element.
        return items[nextHead];
    }

    public T removeLast() {
        if (size == 0) return null;
        size -= 1;
        nextTail = mod(nextTail - 1);
        resize();
        return items[nextTail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
