package trains;


public class CustomLinkedList<T> {

    private Node head;

    void add(T element) {
        Node node = new Node(element);
        if (this.head == null) {
            this.head = node;
        } else {
            Node iterator = this.head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = node;
        }
    }

    void print() {
        Node iterator = head;
        while (iterator != null) {
            System.out.println(iterator.value + " ");
            iterator = iterator.next;
        }
    }

    class Node {

        private final T value;
        private Node next;

        private Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}

