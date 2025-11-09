import java.util.ArrayList;

public class BinaryMaxHeap {

    // Fields
    private ArrayList<Integer> heap;


    // Constructor
    public BinaryMaxHeap() {
        this.heap = new ArrayList<Integer>();
    }


    // Public Methods
    public int size() {
        return this.heap.size();
    }

    /**
     * Adds the given int (representing a priority) to the
     * proper spot in the heap
     *
     * @param toAdd Priority we desire to add
     */
    public void add(int toAdd) {
        // Step 1: Maintain a complete binary tree by adding the
        // new value at the bottom-most left-most leaf spot, AKA
        // an append operation into the AL
        this.heap.add(toAdd);

        // Step 2: Reheapify: bubble-up the value from its current
        // index into one where it is <= parent's
        this.bubbleUp(this.heap.size() -1);
    }

    /**
     * Returns the highest priority
     * item in the heap
     * @return the highest prio item
     */
    public int peek() {
        return this.heap.get(0);
    }

    /**
     * Removes and returns the highest priority
     * item in the heap
     * @return the removed item
     */
    public int poll() {
        int polledValue = this.heap.get(0);

        // Remove and reheapify!
        // Replace root of tree with value in lowest-rightmost
        // leaf (AKA last item)
        int lastValue = this.heap.remove(this.heap.size() - 1);

        if (!this.heap.isEmpty()) {
            this.heap.set(0, lastValue);
            trickleDown(0);
        }

        return polledValue;
    }

    @Override
    public String toString () {
        return this.heap.toString();
    }

    public static void main(String[] args) {
        BinaryMaxHeap b = new BinaryMaxHeap();
        b.add(50);
        b.add(25);
        b.add(20);
        b.add(8);
        b.add(10);
        b.add(8);

        System.out.println("BEFORE POPPING 50");
        System.out.println(b);
        b.poll();
        System.out.println("AFTER POPPING 50");
        System.out.println(b);
    }

    // Private Helpers
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2; // Integer (floor) division!
    }

    private int getChildIndex(int parentIndex, char child) {
        int result = (parentIndex * 2) + 1; // Index of left child
        if (child == 'R') {
            result++;
        }
        return result;
    }

    private void trickleDown(int parentIndex) {
        int leftChildIndex = getChildIndex(parentIndex, 'L'),
            rightChildIndex = getChildIndex(parentIndex, 'R');

        int parent = this.heap.get(parentIndex),
            leftChild = leftChildIndex < this.heap.size() ? this.heap.get(leftChildIndex) : -1,
            rightChild = rightChildIndex < this.heap.size() ? this.heap.get(rightChildIndex) : -1;

        if (parent < leftChild && leftChild >= rightChild) {
            this.heap.set(parentIndex, leftChild);
            this.heap.set(leftChildIndex, parent);
            trickleDown(leftChildIndex);
        } else if (parent < rightChild) {
            this.heap.set(parentIndex, rightChild);
            this.heap.set(rightChildIndex, parent);
            trickleDown(rightChildIndex);
        }
    }

    private void bubbleUp(int index) {
        if (index == 0) {
            return;
        }

        // Get parent node's index, and get current node and
        // parent node's values to compare
        int parentIndex = getParentIndex(index),
            parent = heap.get(parentIndex),
            current = heap.get(index);

        // Check if parent's priority is higher than current,
        // and swap them if so! (and then call bubbleUp again!)
        if (parent < current) {
            heap.set(index, parent);
            heap.set(parentIndex, current);

            bubbleUp(parentIndex);
        }
    }

}