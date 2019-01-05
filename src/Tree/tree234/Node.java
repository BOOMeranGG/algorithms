package Tree.tree234;

public class Node {
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER - 1];

        //Связывание узла с потомком
    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null)
            child.parent = this;
    }

        //Метод отсоединяет потомка от узла и возвращает его
    public Node disconnectChild(int childNum) {
        Node temp = childArray[childNum];
        childArray[childNum] = null;
        return temp;
    }

        //Определение индекса элемента(в пределах узла)
    public int findItem(long key) {
        for (int i = 0; i < ORDER - 1; i++) {
            if (itemArray[i] == null)
                break;
            if (itemArray[i].dData == key)
                return i;
        }
        return -1;
    }

        //Добавление нового элемента
    public int insertItem(DataItem newItem) {
        //Предполагается, что узел не пуст
        numItems++;
        long newKey = newItem.dData;

        for (int i = ORDER - 2; i >= 0; i--) {                  //Начиная справа, проверяем элементы
            if (itemArray[i] == null)                           //Если ячейка пуста, перейти влево
                continue;
            else {
                long itsKey = itemArray[i].dData;
                if (newKey < itsKey)
                    itemArray[i + 1] = itemArray[i];
                else {
                    itemArray[i + 1] = newItem;
                    return i + 1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

        //Удаление наибольшего элемента
    public DataItem removeItem() {
        //Предполагается, что узел не пуст
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    public void displayNode() {
        for (int i = 0; i < numItems; i++) {
            itemArray[i].displayItem();
        }
        System.out.println("/");
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return childArray[0] == null;
    }

    public int getNumItems() {
        return numItems;
    }

    public DataItem getItem(int index) {
        return itemArray[index];
    }

    public boolean isFull() {
        return numItems == ORDER - 1;
    }


}
