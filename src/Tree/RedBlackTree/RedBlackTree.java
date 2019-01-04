package Tree.RedBlackTree;

public class RedBlackTree {
    private Node root;


    public Node find(int key) {
        Node current = root;
        while (current.data != key) {
            if (key < current.data)
                current = current.leftChild;
            else
                current = current.rightChild;
            if (current == null)
                return null;
        }
        return current;
    }

    /**
     * Метод для вставки узла в красно-чёрное дерево.
     */
    public void insert(int key) {
        Node newNode = new Node();
        newNode.data = key;
        if (root == null) {
            root = newNode;
            root.isRed = false;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (ifNeededThenChangeColor(current)) {               //Вызываем метод для проверки, надо ли менять цвет
                    if (isRulesBroken(current)) {                     //Если из-за смена цветов было нарушено правило
                        System.out.println("YEP!");
                        //rightTurn(current);
                    }
                }

                if (key < current.data) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return ;
                    }
                }
            }
        }
    }

    /**
     * Метод переключения цвета. Цвет родителя
     * и его потомков меняется на противоположный.
     * Вначале выполняется проверка: если родитель чёрный
     * а оба его потомка красные, то цвет стоит менять.
     * Возвращаемое значение - нужен ли был поворот.
     */
    private boolean ifNeededThenChangeColor(Node parent) {
        if (!parent.isRed && parent.leftChild != null && parent.rightChild != null
                            && parent.leftChild.isRed && parent.rightChild.isRed) {
            if (parent != root)
                parent.isRed = !parent.isRed;
            parent.leftChild.isRed = !parent.leftChild.isRed;
            parent.rightChild.isRed = !parent.rightChild.isRed;
            return true;
        } else
            return false;
    }

    /**
     * Метод проверяет, нарушено ли правило для узла
     * и его потомков: если узел красный, то его потомки
     * должны быть чёрными. Т.к. метод вызывается только
     * после смены цветов, гарантируется, что переданный узел
     * имеет двух потомков.
     * @param current   - Передаётся узел родителя.
     * @return          - Возвращает true, если правило нарушено.
     */
    private boolean isRulesBroken(Node current) {
        if (current.isRed && (current.leftChild.isRed || current.rightChild.isRed))
            return true;
        return false;
    }

    private void rightTurn(Node topNode) {
        Node top = topNode;
        Node left = topNode.leftChild;
        Node right = topNode.rightChild;
        Node passing = null;

        if (left.rightChild != null)                        //Если существует, запоминаем переходящий узел
            passing = left.rightChild;
        topNode = left;
        topNode.rightChild = top;
        topNode.rightChild.rightChild = right;
        if (passing != null)
            topNode.rightChild.leftChild = passing;
    }

    private void leftTurn(Node topNode) {

    }
}
