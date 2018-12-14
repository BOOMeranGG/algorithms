package sort;

/**
 * Сортировка Шелла
 */
public class ShellSort {
    int[] mas;

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        int n = 10;
        sort.mas = new int[n];

        for (int i = 0; i < n; i++) {
            sort.mas[i] = (int) (Math.random() * 100);
            System.out.print(sort.mas[i] + " ");
        }
        System.out.println();

        sort.shellSort();
        for (int i = 0; i < n; i++) {
            System.out.print(sort.mas[i] + " ");
        }
    }

    public void shellSort() {
        int i;
        int j;
        int temp;
        int h = 1;
        while (h < mas.length / 3)
            h = h * 3 + 1;

        while (h > 0) {
            for (i = h; i < mas.length; i++) {
                temp = mas[i];
                j = i;

                while(j > h - 1 && mas[j - h] > temp) {
                    mas[j] = mas[j - h];
                    j -= h;
                }
                mas[j] = temp;
            }
            h = (h - 1) / 3;
        }
    }

}
