public class BlackRedTree {
    private Node root;

    // создание метода добавления
    public boolean add(int value){
        if (root != null) {
            boolean result = addNode(root, value);
            root = balance(root);
            root.color = Color.black;
            return result;
        }
        else {
            root = new Node();
            root.color = Color.black;
            root.value = value;
            return true;
        }
    }
    // создание метода добавления ноды
    private boolean addNode(Node node, int value){
        if (node.value == value) {
            return false;
        }
        else {
            if (node.value > value){
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = balance(node.leftChild);
                    return result;
                }
                else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.red;
                    node.leftChild.value = value;
                    return true;
                }
            }
            else {
                if (node.rightChild != null){
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = balance(node.rightChild);
                    return result;
                }
                else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.red;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }
    // создание метода балансировки
    private Node balance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.red && (
                    result.leftChild == null || result.leftChild.color == Color.black)) {
                needRebalance = true;
                result = rotateRight(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.red &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.red) {
                needRebalance = true;
                result = rotateLeft(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.red&&
                    result.rightChild != null && result.rightChild.color == Color.red) {
                needRebalance = true;
                swapColor(result);
            }
        }
        while (needRebalance);
        return result;
    }

    // Создание метода для левого малого поворота
    private Node rotateLeft(Node node) {
            Node left = node.leftChild;
            Node right = left.rightChild;
            left.rightChild = node;
            node.leftChild = right;
            left.color = node.color;
            node.color = Color.red;
            return left;
        }

    // Создание метода для правого малого поворота
    private Node rotateRight(Node node) {
        Node right = node.rightChild;
        Node left = right.leftChild;
        right.leftChild = node;
        node.rightChild = left;
        right.color = node.color;
        node.color = Color.red;
        return right;
    }
    // Создание метода для смены цвета
    private void swapColor(Node node) {
        node.rightChild.color = Color.black;
        node.leftChild.color = Color.black;
        node.color = Color.red;
    }
    // создание метода упорядочивания по возрастанию
    public void ascOrder() {
        ascOrder(root);
    }

    private void ascOrder(Node node) {
        if (node != null) {
            ascOrder(node.leftChild);
            System.out.print(node.value + " " + node.color + " ");
            ascOrder(node.rightChild);
        }
    }
}
