package stack.LinkStack;

public class LinkStack {
    private LinkList thiList;

    public LinkStack() {
        thiList = new LinkList();
    }

    public void push(long j) {
        thiList.insertFirst(j);
    }

    public long pop() {
        return thiList.deleteFirst();
    }

    public boolean isEmpty() {
        return thiList.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        thiList.displayList();
    }

}
