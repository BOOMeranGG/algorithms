package recoursive;

/**
 * Выводит всевозможные анаграммы слова
 */
public class Anagram {
    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void main(String[] args) {
        String s = "cats";
        size = s.length();
        count = 0;
        for (int i = 0; i < size; i++) {
            arrChar[i] = s.charAt(i);
        }
        doAnagram(size);
    }

    public static void doAnagram(int newSize) {
        if (newSize == 1)
            return ;
        for (int i = 0; i < newSize; i++) {
            doAnagram(newSize - 1);
            if (newSize == 2)
                displayWord();
            rotate(newSize);
        }
    }

    public static void rotate(int newSize) {                   //Сдвиг всех букв влево, первая буква в конец
        int i;
        int position = size - newSize;
        char temp = arrChar[position];
        for (i = position + 1; i < size; i++) {
            arrChar[i - 1] = arrChar[i];
        }
        //arrChar[size - 1] = temp;
        arrChar[i - 1] = temp;
    }

    public static void displayWord() {
        if (count < 99)
            System.out.print(" ");
        if (count < 9)
            System.out.print(" ");
        System.out.print(++count + " ");
        for (int i = 0; i < size; i++) {
            System.out.print(arrChar[i]);
        }
        System.out.print("    ");
        System.out.flush();
        if (count % 6 == 0)
            System.out.println();
    }
}
