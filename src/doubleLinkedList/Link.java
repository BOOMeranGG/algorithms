package doubleLinkedList;

public class Link {
    public long dData;
    public Link next;
    public Link previous;

    public Link(long d) {
        dData = d;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
