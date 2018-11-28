package LinkList.interIterator;

public class ListIterator {
    private Link current;
    private Link previous;
    private LinkList ourList;

    public ListIterator(LinkList list) {
        ourList = list;
        reset();
    }

    public void reset() {                       //Возврат к first
        current = ourList.getFirst();
        previous = null;
    }

    public boolean atEnd() {                    //true, если текущий элемент последний
        return (current.next == null);
    }

    public void nextLink() {                    //Переход к следующему элементу
        previous = current;
        current = current.next;
    }

    public Link getCurrent() {
        return current;
    }

    public void insertAfter(long dd) {          //Вставка после текущего элемента
        Link newLink = new Link(dd);

        if (ourList.isEmpty()) {
            ourList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();                         //Переход к новому элементу
        }
    }

    public void insertBefore(long dd) {         //Вставка перед текущим элементом
        Link newLink = new Link(dd);

        if (previous == null) {                 //В начале списка(или список пуст)
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public long deleteCurrent() {
        long value = current.dData;
        if (previous == null) {             //Если в начале списка
            ourList.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd())
                reset();
            else
                current = current.next;
        }
        return value;
    }
}
