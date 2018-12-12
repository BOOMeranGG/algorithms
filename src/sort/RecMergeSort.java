package sort;

/**
 * Рекурсивная реализация сортировки слиянием
 */
public class RecMergeSort {
    int mas[];

    public static void main(String[] args) {
        RecMergeSort m = new RecMergeSort();
        int n = 10;
        m.mas = new int[n];

        for (int i = 0; i < n; i++) {
            m.mas[i] = (int) (Math.random() * 100);
            System.out.print(m.mas[i] + " ");
        }
        System.out.println();

        int[] work = new int[n];
        m.recMergeSort(work, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(m.mas[i] + " ");
        }
    }

    public void recMergeSort(int[] work, int lower, int upper) {
        if (lower == upper)
            return ;
        int mid = (lower + upper) / 2;
            //Левая часть
        recMergeSort(work, lower, mid);
            //Правая часть
        recMergeSort(work, mid + 1, upper);
            //Слияние
        merge(work, lower, mid, upper);
    }

    /**
     * Метод для слияние двух массивов
     * @param work  - временный массив
     * @param lower - нижний индекс первого массива, который соединяем
     * @param mid   - середина, разделяющая 2 массива, которые соединяем
     * @param upperBound - верхняя граница второго массива, который соединяем
     */
    public void merge(int[] work, int lower, int mid, int upperBound) {
        int j = 0;
        int upper = mid + 1;                        //От середины+1 начинается второй массив
        int countElem = upperBound - lower + 1;
        int lowerSave = lower;

        while (lower <= mid && upper <= upperBound) {
            if (mas[lower] < mas[upper])
                work[j++] = mas[lower++];
            else
                work[j++] = mas[upper++];
        }
        while (lower <= mid)
            work[j++] = mas[lower++];
        while (upper <= upperBound)
            work[j++] = mas[upper++];

        for (int i = 0; i < countElem; i++) {
            mas[lowerSave + i] = work[i];
        }
    }


}
