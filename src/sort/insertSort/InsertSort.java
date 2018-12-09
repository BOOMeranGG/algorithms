package sort.insertSort;

public class InsertSort {
    static int[] num = {1, -6, 23, -25, 44, 123, 1290, -456, 0};

    public static void main(String[] args) {
        insertS();
        for (int n : num) {
            System.out.print(n + " ");
        }
    }

    public static void insertS() {
        int temp = 0, j = 0;
        for (int i = 1; i < num.length ; i++) {
            temp = num[i];
            j = i;
            while (j > 0 && num[j - 1] > temp) {
                num[j] = num[j - 1];
                j--;
            }
            num[j] = temp;
        }
    }
}
