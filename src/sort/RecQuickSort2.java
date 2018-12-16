package sort;

/**
 * Реализация быстрой сортировка по медиане из 3х точек
 */
public class RecQuickSort2 {
    int[] mas;

    public static void main(String[] args) {
        RecQuickSort2 sort = new RecQuickSort2();
        sort.start();
    }

    private void start() {
        int n = 20;
        mas = new int[n];

        for (int i = 0; i < n; i++) {
            mas[i] = (int) (Math.random() * 10);
            System.out.print(mas[i] + " ");
        }
        System.out.println();

        quickSort(0, mas.length - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(mas[i] + " ");
        }
    }

    private void quickSort(int left, int right) {
        int size = right - left + 1;
        if (size < 10)
            insertionSort(left, right);                         //Сортировка вставкой при малом размере
        else {                                                  //Быстрая сортировка при большом размере
            int median = medianOf3(left, right);
            int partition = partition(left, right, median);
            quickSort(left, partition - 1);
            quickSort(partition + 1, right);
        }
    }

    private void insertionSort(int left, int right) {
        int i, j;
        for (i = left + 1; i <= right; i++) {
            int temp = mas[i];
            j = i;
            while (j > left && mas[j - 1] > temp) {
                mas[j] = mas[j - 1];
                j--;
            }
            mas[j] = temp;
        }
    }

    private int partition(int left, int right, int pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (mas[++leftPtr] < pivot)
                ;
            while (mas[--rightPtr] > pivot)
                ;
            if (leftPtr > rightPtr)
                break;
            swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right - 1);                               //Восстановление опорного элемента
        return leftPtr;                                            //Позиция разбиения
    }

    private void swap(int i, int j) {
        int temp = mas[i];
        mas[i] = mas[j];
        mas[j] = temp;
    }

    private int medianOf3(int left, int right) {
        int center = (left + right) / 2;

        if (mas[left] > mas[center])
            swap(left, center);
        if (mas[left] > mas[right])
            swap(left, right);
        if (mas[center] > mas[right])
            swap(center, right);

        swap(center, right - 1);                                //Размещение медианы на правом краю
        return mas[right - 1];                                     //Возвращает медиану
    }
}
