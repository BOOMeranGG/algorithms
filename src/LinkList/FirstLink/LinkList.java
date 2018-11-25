package LinkList.FirstLink;

/**
 * Одна из реализаций односвязного списка
 */
public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id, double dd) {    //Вставка элемента в начало списка
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {                     //Удаление первого элемента
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link find(int key) {                     //Поиск элемента с заданным ключом
        Link current = first;
        while (current.iData != key) {
            if (current.next == null)
                return null;
            current = current.next;
        }
        return current;
    }

    public Link delete(int key) {                   //Удаление элемента с заданным ключом
        Link current = first;
        Link previous = first;
        while (current.iData != key) {
            if (current.next == null)
                return null;
            previous = current;
            current = current.next;
        }
        if (current == first)                       //Если это первый элемент
            first = first.next;
        else
            previous.next = current.next;
        return current;
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
