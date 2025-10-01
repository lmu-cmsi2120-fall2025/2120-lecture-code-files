import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IntStackTests {

    public static void main (String[] args) {
        Stack<String> stacky = new Stack<>();
        stacky.add("a");
        stacky.add("b");
        stacky.add("c");
        // pop removes and returns top of stack
        stacky.pop();

        // peek returns top of stack
        // [?] What gets printed here?
        System.out.println(stacky.peek());

        // Queue (Interface) implemented with LinkedList
        Queue<String> q = new LinkedList<String>();
        // add pushes an item to the back of the Queue
        q.add("a");
        q.add("b");
        q.add("c");
        // poll dequeues and returns item at front
        q.poll();

        // peek returns item at front
        // [?] What gets printed here?
        System.out.println(q.peek());
    }

}