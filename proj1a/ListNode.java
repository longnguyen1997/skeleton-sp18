public class ListNode<T> {
    T value;
    ListNode<T> previous;
    ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T value) {
        this.value = value;
    }

    public ListNode(T value, ListNode<T> previous, ListNode<T> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public void setPrevious(ListNode<T> previous) {
        this.previous = previous;
    }
}
