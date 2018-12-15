package sort;

/**
 * Разбиение массива на 2 части
 */
public class Partition {
    int[] mas;

    public static void main(String[] args) {
        Partition part = new Partition();
        part.start();
    }

    public void start() {
        int n = 10;
        mas = new int[n];

        for (int i = 0; i < n; i++) {
            mas[i] = (int) (Math.random() * 100);
            System.out.print(mas[i] + " ");
        }
        System.out.println();

        int pivot = 50;                                 //Опорное значение

        int posBetween = partition(0, mas.length - 1, pivot);
        System.out.println("Опорный элемент = " + pivot + " , разбиение между индексом " + posBetween);
        for (int i = 0; i < n; i++) {
            System.out.print(mas[i] + " ");
        }
    }

    public int partition(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while (true) {
            while (leftPtr < right && mas[++leftPtr] < pivot)   //Поиск большего элемента
                ;
            while (rightPtr > left && mas[--rightPtr] > pivot)  //Поиск меньшего элемента
                ;
            if (leftPtr >= rightPtr)                            //Если указатели пересеклись
                break;                                          //Разбиение закончено
            else                                                //Иначе, меняем элементы местами
                swap(leftPtr, rightPtr);
        }
        return leftPtr;
    }

    public void swap(int i, int j) {
        int temp = mas[i];
        mas[i] = mas[j];
        mas[j] = temp;
    }
}
