package Tree.BinaryTree;

public class TreeApp {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(50, 1.5);
        tree.insert(25, 1.7);
        tree.insert(75, 1.9);

        //tree.delete(25);
        Node found = tree.find(25);
        if (found != null)
            System.out.println("Found the node with the key 25");
        else
            System.out.println("Could not find node with key 25");
    }
}
