package LinkList.interIterator;

/**
 * Связанный список с итератором
 */
public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public Link getFirst() {                                //Получение первого элемента
        return first;
    }

    public void setFirst(Link f) {                          //Присваивание нового значения first
        first = f;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public ListIterator getIterator() {                     //Получение итератора
        return new ListIterator(this);                      //Инициализация списком this
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
