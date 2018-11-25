package Queue.LinkQueue;

public class LinkQueue {
    private FirstLastList thiList;

    public LinkQueue() {
        thiList = new FirstLastList();
    }

    public boolean isEmpty() {
        return thiList.isEmpty();
    }

    public void insert(long j) {
        thiList.insertLast(j);
    }

    public long remove() {
        return thiList.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        thiList.displayList();
    }
}
