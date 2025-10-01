public class BattleTest {

    public static void changeNumber(int[] x, int y, int index) {
        System.out.println("In changeNumber: " + x);
        x[index] = y;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3};
        System.out.println("In Main: " + x);
        changeNumber(x, 20, 2);

        System.out.println(x[2]);


    }

}
