public class ConstructedIntStack implements TrueIntStack {
    private final IntLinkedList list;

    public ConstructedIntStack() {
        this.list = new IntLinkedList();
    }

    public void push(int toPush) {
        list.prepend(toPush);
    }

    public void pop() {
        list.removeAt(0);
    }

    public int peek() {
        return list.getAt(0);
    }
}