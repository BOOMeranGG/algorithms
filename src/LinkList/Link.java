package LinkList;

public class Link {
    public int iData;               //Данные (ключ)
    public double dData;            //Данные
    public Link next;               //Следующийй элемент в списке

    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void displayLink() {
        System.out.print("{" + iData + ", " + dData + "}");
    }
}
