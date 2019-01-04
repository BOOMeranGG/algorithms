package Tree.RedBlackTree;

public class RedBlackTreeApp {
    public static void main(String[] args) {
        RedBlackTree rbTree = new RedBlackTree();
        rbTree.insert(50);
        rbTree.insert(25);
        rbTree.insert(75);
        rbTree.insert(12);
        rbTree.insert(37);
        rbTree.insert(6);
        rbTree.insert(18);
        rbTree.insert(3);

        System.out.println(rbTree.find(50).isRed);
        System.out.println(rbTree.find(25).isRed);
        System.out.println(rbTree.find(75).isRed);
        System.out.println(rbTree.find(12).isRed);
        System.out.println(rbTree.find(37).isRed);
        System.out.println(rbTree.find(6).isRed);
        System.out.println(rbTree.find(18).isRed);
        System.out.println(rbTree.find(3).isRed);
    }
}
