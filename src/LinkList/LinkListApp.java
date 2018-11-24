package LinkList;

public class LinkListApp {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insertFirst(22, 2.99);
        list.insertFirst(44, 4.99);
        list.insertFirst(66, 6.99);
        list.insertFirst(88, 8.99);

        list.displayList();

        Link f = list.find(44);
        if (f != null)
            System.out.println("Found link with the key: " + f.iData);
        else
            System.out.println("Can't find link");

        Link d = list.delete(66);
        if (d != null)
            System.out.println("Found link with the key: " + d.iData);
        else
            System.out.println("Can't find link");list.displayList();
    }
}
