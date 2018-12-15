package sort;

public class RecQuickSort {
    int[] mas;

    public static void main(String[] args) {
        RecQuickSort sort = new RecQuickSort();
        sort.start();
    }

    public void start() {
        int n = 10000;
        mas = new int[n];

        for (int i = 0; i < n; i++) {
            mas[i] = (int) (Math.random() * 100);
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        quickSort(0, mas.length - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(mas[i] + " ");
        }
    }

    public void quickSort(int left, int right) {
        if (right - left <= 0)
            return ;
        int pivot = mas[right];                                  //Крайний правый элемент, как опорный

        int partition = partition(left, right, pivot);           //Разбиение диапазона
        quickSort(left, partition - 1);                    //Сортировка левой части
        quickSort(partition + 1, right);                    //Сортировка правой части
    }

    public int partition(int left, int right, int pivot) {
        int leftPtr = left - 1;                                 //Левая граница(после++)
        int rightPtr = right;                                   //Правая граница - 1(после --)

        while (true) {
            while (mas[++leftPtr] < pivot)                      //Поиск большего элемента
                ;
            while (rightPtr > 0 && mas[--rightPtr] > pivot)     //Поиск меньшего элемента
                ;
            if (leftPtr >= rightPtr)                            //Если указатели пересеклись
                break;                                          //Разбиение закончено
            else                                                //Иначе, меняем элементы местами
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right);                                   //Перестановка опорного элемента
        return leftPtr;                                         //Возврат позиции опорного элемента
    }

    public void swap(int i, int j) {
        int temp = mas[i];
        mas[i] = mas[j];
        mas[j] = temp;
    }
}
