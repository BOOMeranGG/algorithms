package Queue;

/**
 * Циклическая очередь
 */
public class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int k) {
        maxSize = k;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long k) {        //Вставка элемента в конец очереди
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = k;
        nItems++;
    }

    public long remove() {              //Извлечение элемента из начала очереди
        long temp = queArray[front];
        if (front == maxSize - 1)
            front = -1;
        front++;
        nItems--;
        return temp;
    }

    public long peekFont() {            //Чтение элемента из начала списка
        return queArray[front];
    }

    public boolean isEmpty() {          //true, если очередь пуста
        return (nItems == -0);
    }

    public boolean isFull() {           //true, если очередь заполнена
        return (nItems == maxSize);
    }

    public int size() {                 //Возвращает кол-во элементов в очереди
        return nItems;
    }
}
