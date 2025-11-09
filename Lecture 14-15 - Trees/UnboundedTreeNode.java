import java.util.ArrayList;

public class UnboundedTreeNode {

    public int data;
    public ArrayList<UnboundedTreeNode> children;

    public UnboundedTreeNode(int data) {
        this.data = data;
        this.children = new ArrayList<UnboundedTreeNode>();
    }

    public void addChild(int toAdd) {
        this.children.add(new UnboundedTreeNode(toAdd));
    }

    public UnboundedTreeNode getChild(int index) {
        return children.get(index);
    }

    public int getData() {
        return this.data;
    }

    public static void main (String[] args) {
        UnboundedTreeNode root = new UnboundedTreeNode(5);
        root.addChild(4);
        root.addChild(2);
        root.addChild(1);
        UnboundedTreeNode it = root.getChild(1);
        it.addChild(2);
        it.addChild(3);
    }
}
