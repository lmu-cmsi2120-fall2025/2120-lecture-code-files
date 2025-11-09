import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {
        PriorityQueue<Forneymon> fmTriage = new PriorityQueue<>();
        Burnymon b1 = new Burnymon("b1"),
                b2 = new Burnymon("b2"),
                b3 = new Burnymon("b3");

        b2.takeDamage(10, "Burny");
        b3.takeDamage(5, "Burny");
        fmTriage.add(b1);
        fmTriage.add(b2);
        fmTriage.add(b3);

        // [?] In what order will the Burnymon be polled below?
        while (!fmTriage.isEmpty()) {
            System.out.println(fmTriage.poll());
        }
    }
}