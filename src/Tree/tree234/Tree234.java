package Tree.tree234;

/**
 * Класс-реализация дерева 2-3-4(нисходящее дерево)
 */
public class Tree234 {
    private Node root = new Node();

    public int find(long key) {
        Node curNode = root;
        int childNumber;
        while (true) {
            if ((childNumber = curNode.findItem(key)) != -1)
                return childNumber;
            else if (curNode.isLeaf())
                return -1;
            else
                curNode = getNextChild(curNode, key);
        }
    }

    public void insert(long dValue) {
        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);

        while (true) {
            if (curNode.isFull()) {                             //Если узел полон, то мы его разбиваем
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, dValue);
            }
            else if (curNode.isLeaf())                          //Если узел листовой, переходим к вставке
                break;
            else
                curNode = getNextChild(curNode, dValue);        //Узел не полный  ине листовой, спускаемся дальше
        }
        curNode.insertItem(tempItem);
    }

    public void split(Node thisNode) {                          //Разбиение узла
        //Предполагается, что узел полон
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;

            //Далее сохранем данные B и C(A остаётся на своём месте), два правых потомка, и создаём новый узел
        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        Node newRight = new Node();

        if (thisNode== root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
        }
            //Разбираемся с родителем
        itemIndex = parent.insertItem(itemB);                   //B вставляется в родителя
        int n = parent.getNumItems();

        for (int i = n - 1; i < itemIndex; i--) {               //Перемещения связей родителя на 1 потомка вправо
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i + 1, temp);
        }

        parent.connectChild(itemIndex + 1, newRight);
            //Разбираемся с newRight
        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

        //Получение соответствующего потомка при поиске значения
    public Node getNextChild(Node theNode, long theValue) {
            //Предполагается, что узел не пуст, не полон и не является листом
        int i;
        int numItems = theNode.getNumItems();

        for (i = 0; i < numItems; i++) {
            if (theValue < theNode.getItem(i).dData)            //Если наше значение меньше, вернуть левого потомка
                return theNode.getChild(i);
        }
        return theNode.getChild(i);
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node thisNode, int level, int childNumder) {
        System.out.print("Level = " + level + " child = " + childNumder + " ");
        thisNode.displayNode();

        //Рекурсивный вызов для каждого потомка текущего узла
        int numItems = thisNode.getNumItems();
        for (int i = 0; i < numItems + 1; i++) {
            Node nextNode = thisNode.getChild(i);
            if (nextNode != null)
                recDisplayTree(nextNode, level + 1, i);
            else
                return;
        }
    }
}
