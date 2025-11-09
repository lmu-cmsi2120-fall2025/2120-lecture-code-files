import java.util.*;

public class TreeSetTests {

    private static int TEST_SIZE = 200000;

    public static void testArrayListMembership () {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            // [!] Appending i to ArrayList
            arr.add(i);
        }
        for (int i = 0; i < TEST_SIZE; i++) {
            // [!] Membership tests
            arr.contains(i);
        }
    }

    public static void testTreeSetMembership() {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            // [!] Adding i to BinarySearchTree
            ts.add(i);
        }
        for (int i = 0; i < TEST_SIZE; i++) {
            // [!] Membership tests
            ts.contains(i);
        }
    }

    public static void main(String[] args) {
        testTreeSetMembership();
    }

}