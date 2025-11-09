import java.util.ArrayList;

public class BST {

    private BSTNode root;

    public BST() {
        this.root = null;
    }

    public void add(int toAdd) {
        if (this.root == null) {
            this.root = new BSTNode(toAdd);
            return;
        }
        BSTNode current = this.root;
        while (current != null) {
            if (toAdd < current.data) {
                if (current.left == null) {
                    current.left = new BSTNode(toAdd);
                    return;
                }
                current = current.left;
            }
            if (toAdd > current.data) {
                if (current.right == null) {
                    current.right = new BSTNode(toAdd);
                    return;
                }
                current = current.right;
            }
        }
    }

    public void addRec (int toAdd) {
        this.root = this.addRec(this.root, toAdd);
    }

    private BSTNode addRec (BSTNode n, int toAdd) {
        if (n == null) {
            return new BSTNode(toAdd);
        }
        if (toAdd < n.data) {
            n.left = addRec(n.left, toAdd);
        } else if (toAdd > n.data) {
            n.right = addRec(n.right, toAdd);
        }
        return n;
    }

    public boolean contains(int query) {
        BSTNode current = this.root;
        while (current != null) {
            if (query == current.data) {
                return true;
            }
            current = query < current.data ? current.left : current.right;
        }
        return false;
    }

    // Returns a list of all leaves in tree
    public ArrayList<Integer> getLeaves() {
        ArrayList<Integer> result = new ArrayList<>();
        getLeaves(this.root, result);
        return result;
    }

    private void getLeaves(BSTNode n, ArrayList<Integer> result) {
        if (n == null) { return; }
        // I know a node is a leaf if it has no children
        if(n.left == null && n.right == null) {
            result.add(n.data);
        } else {
            getLeaves(n.left, result);
            getLeaves(n.right, result);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.add(10);
        tree.add(2);
        tree.add(12);
        tree.add(4);
        tree.add(3);
        tree.add(11);
        System.out.println(tree.getLeaves()); // true
    }

    private class BSTNode {

        int data;
        BSTNode left, right;

        BSTNode(int d) {
            this.data = d;
        }
    }
}
