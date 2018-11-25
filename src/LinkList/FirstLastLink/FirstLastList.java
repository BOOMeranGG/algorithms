package LinkList.FirstLastLink;

/**
 * Реализация двустороннего списка(хранится ссылка на первый и последний элемент)
 */
public class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(long dd) {              //Вставка элемента в начало списка
        Link newLink = new Link(dd);
        if (isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd) {               //Вставка элемента в конец списка
        Link newLink = new Link(dd);
        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public long deleteFirst() {                     //Удаление первого элемента(предполагается, что список не пуст)
        long temp = first.dData;
        if (first.next == null)                     //Если только один элемент
            last = null;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
