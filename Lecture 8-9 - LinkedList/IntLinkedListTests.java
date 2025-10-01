public class IntLinkedListTests {

    public static void main (String[] args) {
         IntLinkedList llCoolJ = new IntLinkedList();
        llCoolJ.append(1);
        llCoolJ.append(2);
        llCoolJ.append(3);
        System.out.println(llCoolJ.getAt(0));  // 1
        System.out.println(llCoolJ.getAt(1));  // 2
        System.out.println(llCoolJ.getAt(2));  // 3

        llCoolJ = new IntLinkedList();
        llCoolJ.prepend(3);
        llCoolJ.prepend(2);
        llCoolJ.prepend(1);
        llCoolJ.removeAt(1);
        System.out.println(llCoolJ.getAt(0)); // 1
        System.out.println(llCoolJ.getAt(1)); // 3

        llCoolJ = new IntLinkedList();
        llCoolJ.prepend(3);
        llCoolJ.prepend(2);
        llCoolJ.prepend(1);
        IntLinkedList.Iterator it = llCoolJ.getIterator();
        System.out.println(it.getCurrentInt()); // 1
        it.next(); // Advance the iterator one node
        System.out.println(it.getCurrentInt()); // 2
        it.next(); // Advance the iterator one node
        System.out.println(it.getCurrentInt()); // 3

        IntLinkedList var1 = new IntLinkedList();
        var1.append(5);
        var1.append(8);
        var1.append(9);
        var1.append(67);
        var1.append(18);
        IntLinkedList.Iterator var2 = var1.getIterator();

        // Print the first element
        System.out.println(var2.getCurrentInt());

        // Print remaining elements
        while(var2.hasNext()) {
            var2.next();
            System.out.println(var2.getCurrentInt());
        }

        IntList inty = new IntLinkedList();
        inty.append(5);   // OK because append is in the IntList
        // inty.prepend(1);  // NOT OK because prepend is not in the interface
    }

}