public class Node extends BlackRedTree {
    private Node root;
    Color color;
    int value;
    Node leftChild;
    Node rightChild;

    @Override
    public String toString() {
        return "Node{" +
                "color=" + color +
                ", value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}

