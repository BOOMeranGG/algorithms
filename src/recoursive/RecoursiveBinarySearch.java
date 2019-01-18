package recoursive;

/**
 * Реализация бинарного поиска с помощью рекурсии
 */
public class RecoursiveBinarySearch {
    int[] mas;

    public static void main(String[] args) {
        RecoursiveBinarySearch r = new RecoursiveBinarySearch();
        r.start();
    }

    public void start() {
        int n = 10;
        mas = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = i * 2 + 1;
            System.out.println(i + "я позиция, число: " + mas[i]);
        }
        int num = 5;
        int ans = search(num);
        if (ans >= 0)
            System.out.println("\n" + "Число " +  num + " находится в позиции № " + ans);
        else
            System.out.println("Число не найдено");
    }

    public int search(int key) {
        return recBinarySearch(key, 0, mas.length - 1);
    }

    public int recBinarySearch(int key, int lower, int upper) {
        int currentIn = (lower + upper) / 2;                                //Сломается при больших размерах массива
        if (mas[currentIn] == key)
            return currentIn;
        else if (lower > upper)                                             //Элемент не найден
            return -1;
        else {
            if (mas[currentIn] > key)
                return recBinarySearch(key, lower, currentIn - 1);
            else
                return recBinarySearch(key, currentIn + 1, upper);
        }
    }
}
