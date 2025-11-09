public class BinaryTreeNode {

    public int data;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public static void preorderPrint (BinaryTreeNode n) {
        if (n == null) {return;}
        System.out.println(n.data);
        preorderPrint(n.left);
        preorderPrint(n.right);
    }

    public static void postorderPrint (BinaryTreeNode n) {
        if (n == null) {return;}
        preorderPrint(n.left);
        preorderPrint(n.right);
        System.out.println(n.data);
    }

    public static void inorderPrint (BinaryTreeNode n) {
        if (n == null) {return;}
        preorderPrint(n.left);
        System.out.println(n.data);
        preorderPrint(n.right);
    }

    public static void main (String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(2);
        BinaryTreeNode it = root.left;
        it.left = new BinaryTreeNode(1);
        it.right = new BinaryTreeNode(0);
        it = root.right;
        it.left = new BinaryTreeNode(8);
    }
}
