package sort.selectSort;

public class selectSort {
    static int[] num = {1, -6, 23, -25, 44, 123, 1290, -456, 0};

    public static void main(String[] args) {
        selectionSort();
        for (int n : num) {
            System.out.print(n + " ");
        }
    }

    public static void selectionSort() {
        int min = 0, out = 0, in = 0;
        for (int i = 0; i < num.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[min])
                    min = j;
            }
            int k = num[i];
            num[i] = num[min];
            num[min] = k;
        }
    }
}
