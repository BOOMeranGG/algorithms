package Queue;

public class PriorityQ {
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQ(int k) {
        maxSize = k;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long k) {            //Вставка элемента
        int j = 0;

        if (nItems == 0)
            queArray[nItems++] = k;
        else {
            for (j = nItems - 1; j >= 0; j--) {
                if (k > queArray[j])
                    queArray[j + 1] = queArray[j];
                else
                    break;
            }
            queArray[j + 1] = k;
            nItems++;
        }
    }

    public long remove() {                  //Извлечение минимального элемента
        return queArray[--nItems];
    }

    public long peekMin() {                 //Чтение минимального элемента
        return queArray[nItems];
    }

    public boolean isEmpty() {              //true, если очередь пуста
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }
}
