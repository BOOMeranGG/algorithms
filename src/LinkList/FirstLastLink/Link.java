package LinkList.FirstLastLink;

public class Link {
    public long dData;
    public Link next;

    public Link(long data) {
        dData = data;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
