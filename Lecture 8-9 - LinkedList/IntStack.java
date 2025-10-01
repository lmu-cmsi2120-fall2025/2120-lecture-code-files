public class IntStack extends IntLinkedList {

    IntStack () {
        super();
    }

    public void push (int toPush) {
        super.prepend(toPush);
    }

    public void pop () {
        super.removeAt(0);
    }

    public int peek () {
        return super.getAt(0);
    }

}