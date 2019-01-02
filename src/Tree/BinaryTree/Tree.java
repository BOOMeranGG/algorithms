package Tree.BinaryTree;

/**
 * Дерево двоичного поиска
 */
public class Tree {
    private Node root;

    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {
            if (key < current.iData)
                current = current.leftChild;
            else
                current = current.rightChild;
            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if (root == null)                       //Если корневой узел не существует
            root = newNode;
        else {
            Node current = root;                    //Начинаем с корневого узла
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData) {           //Двигаться налево?
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {                            //Двигаться направо?
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {                //Удаление узла с заданным ключом
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {              //Двигается налево?
                isLeftChild = true;
                current = current.leftChild;
            } else {                                //Иначе, направо
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;
        }                                           //Удаляемый узел найден

            //Если узел не имеет потомков, то мы его просто удаляем
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)                   //Узел отсоединяется от родителя
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }

            //Удаляемый узел имеет одного потомка(левый)
        else if (current.rightChild == null) {
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)           //Левый потомок родителя
                parent.leftChild = current.leftChild;
            else                            //Правый потомок родителя
                parent.rightChild = current.leftChild;
        }
            //Удаляемый узел имеет одного потомка(правый)
        else if (current.leftChild == null) {
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)           //Левый потомок родителя
                parent.leftChild = current.rightChild;
            else                            //Правый потомок родителя
                parent.rightChild = current.rightChild;
        }

            //Удаляемый узел имеет двух потомков
        else {
            Node successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
                //Преемник связывается с левым потомком current
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {           //Если преемник не правый потомок
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
}
