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
        int count = 0;
        if (root == null) {
            root = newNode;
            root.isRed = false;
        } else {
            Node current = root;
            Node parent = current;
            Node grandPa = null;
            Node grandGrandPa = null;
            while (true) {
                if (ifNeededThenChangeColor(current)) {               //Вызываем метод для проверки, надо ли менять цвет
                }
                if (grandPa != null && isRulesBroken(parent)) {                      //Если из-за смена цветов было нарушено правило
                    System.out.println("YEP!");
                    rightTurn(grandPa, grandGrandPa);              //Временно только правый поворот
                }
                count++;
                if (count > 2)
                    grandGrandPa = grandPa;
                if (count > 1)
                    grandPa = parent;
                parent = current;

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
     * должны быть чёрными.
     * @param current   - Передаётся узел родителя.
     * @return          - Возвращает true, если правило нарушено.
     */
    private boolean isRulesBroken(Node current) {
        if (current.isRed && current.leftChild != null && current.rightChild != null
                            && (current.leftChild.isRed || current.rightChild.isRed))
            return true;
        return false;
    }

    private void rightTurn(Node grandPa, Node grandGrandPa) {
        boolean isRoot = false;
        if (grandGrandPa == null)
            isRoot = true;
        Node main = grandPa;
        Node top = grandPa.leftChild;
        Node left = grandPa.leftChild;
        Node right = grandPa.rightChild;
        Node passing = null;

        if (left.rightChild != null)                        //Если существует, запоминаем переходящий узел
            passing = left.rightChild;
        if (isRoot) {                                       //Тут магия, пока не разберёшься, НЕ ТРОЖЬ!!!!
            root = left;
            main.leftChild = passing;
            left.rightChild = main;
        } else {

        }
    }

    private void leftTurn(Node topNode) {

    }
}
