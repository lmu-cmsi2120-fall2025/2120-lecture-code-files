public class IntLinkedList implements IntList {

    private int size;
    private Node head;

    IntLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void append(int toAdd) {
        Node toAppend = new Node(toAdd);
        this.size++;

        if (this.head == null) {
            this.head = toAppend;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = toAppend;
    }

    public void prepend (int toAdd) {
        Node toPrepend = new Node(toAdd);
        toPrepend.next = this.head;
        this.head = toPrepend;
        this.size++;
    }

    public int getAt (int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Requested index out of range");
        }

        Node current = this.head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        return current.data;
    }

    public void removeAt (int index) {
        if (index >= this.size || index < 0) {
            throw new IllegalArgumentException("index out of legal range");
        }

        Node current = this.head;
        Node prev = null;

        while (current != null && index > 0) {
            prev = current;
            current = current.next;
            index--;
        }

        if (current == this.head) {
            this.head = current.next;
        }

        if (prev != null) {
            prev.next = current.next;
        }
        size--;
    }

    /**
     * Hmm... this one seems unimplemented.
     * Perhaps this is good practice for future assessment?
     */
    public void insertAt (int toAdd, int index) {
        throw new UnsupportedOperationException();
    }

    public Iterator getIterator () {
        return new Iterator(this);
    }

    private class Node {

        int data;
        Node next;

        Node (int d) {
            this.data = d;
            this.next = null;
        }

    }

    public class Iterator {

        private Node current;

        private Iterator (IntLinkedList host) {
            this.current = host.head;
        }

        public void next() {
            if (this.current == null) {
                return;
            }
            this.current = this.current.next;
        }

        public int getCurrentInt() {
            return this.current.data;
        }

        public boolean hasNext() {
            return this.current != null && this.current.next != null;
        }

    }

}