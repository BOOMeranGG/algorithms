package HaffmanCode;

import java.util.*;

/**
 * По данной непустой строке s длины не более 10^4, состоящей
 * из строчных букв латинского алфавита, постройте оптимальный
 * беспрефиксный код. В первой строке выведите количество различных
 * букв k, встречающихся в строке, и размер получившейся закодированной
 * строки. В следующих k строках запишите коды букв в формате
 * "letter: code". В последней строке выведите закодированную строку.
 * CORRECTLY!
 */
public class HaffmanCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        String str = sc.nextLine();
        List<Letter> letterList = new ArrayList<>();
        StringBuilder strAfterCode = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Integer count = map.get(ch);
            map.put(ch, count == null ? 1 : count + 1);
        }

        for (Map.Entry entry  : map.entrySet()) {                                           //Формируем все буквы в список
            letterList.add(new Letter((char) entry.getKey(), (int) entry.getValue()));      //В виде(символ-количество)
        }

        while (letterList.size() > 1) {
            Letter newRoot;
            Letter firstMin;
            Letter secondMin;

            int min1 = getMinLetterIndex(letterList);                 //Ищем первую и вторую наименее встречаемые символы
            firstMin = letterList.get(min1);
            letterList.remove(min1);
            int min2 = getMinLetterIndex(letterList);
            if (min2 != -1) {                                         //Если равен -1, то элементов в списке не осталось
                secondMin = letterList.get(min2);
                letterList.remove(min2);
                newRoot = new Letter(firstMin, secondMin);
                newRoot.count = firstMin.count + secondMin.count;
                letterList.add(newRoot);
            } else {
                System.out.println("NOT WORKED! ИСПРАВЬ!");
                break;
            }
        }

        Letter root = letterList.get(0);
        initCodeInGraph(root, new StringBuilder());
        for (int i = 0; i < str.length(); i++) {
            Letter let = findInTree(str.charAt(i), root);
            strAfterCode.append(let.code);
        }
        System.out.println(map.size() + " " + strAfterCode.length());
        searchInGraph(root);
        System.out.println(strAfterCode);
    }

    /**
     * Метод возвращает индекс элемента, который реже других встречается
     * в переданном списке. Возвращает -1, если список пустой.
     * @param list  - список, по которому будет происходить поиск
     * @return      - индекс наименьшего элемента(по переменной count)
     */
    private static int getMinLetterIndex(List<Letter> list) {
        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).count < min) {
                min = list.get(i).count;
                index = i;
            }
        }
        return index;
    }

    /**
     * Рекурсивный метод поиска в глубину по двоичному дереву.
     * Нужен для вывода всего графа
     */
    private static void searchInGraph(Letter root) {
        if (root.letter != null)                                        //Если ячейка содержит символ - печатаем
            System.out.println(root);
        if (root.leftChild == null && root.rightChild == null)          //Если детей нет - выход
            return;
        if (root.leftChild != null)                                     //Левый ребёнок
            searchInGraph(root.leftChild);
        if (root.rightChild != null)                                    //Правый ребёнок
            searchInGraph(root.rightChild);
    }

    /**
     * Инициализирует переменную code для каждой буквы в дереве.
     * Другими словами, кодирует все символы в изначальной строке.
     */
    private static void initCodeInGraph(Letter root, StringBuilder code) {
        if (root.leftChild == null && root.rightChild == null) {            //Если детей нет, значит этот элемент - символ
            if (code.toString().equals(""))
                code.append("0");
            root.code = code;
        } else {
            if (root.leftChild != null)                                                 //Левый ребёнок
                initCodeInGraph(root.leftChild, new StringBuilder(code.append("0")));
            code.deleteCharAt(code.length() - 1);
            if (root.rightChild != null)                                                //Правый ребёнок
                initCodeInGraph(root.rightChild, new StringBuilder(code.append("1")));
        }
    }

    /**
     *
     */
    private static Letter findInTree(char ch, Letter root) {
        Letter need;

        if (root.leftChild == null && root.rightChild == null) {            //Эта ячейка - символ
            if (ch == root.letter)
                return root;
        }
        if (root.leftChild != null) {
            need = findInTree(ch, root.leftChild);
            if (need != null)
                return need;
        }
        if (root.rightChild != null) {
            need =  findInTree(ch, root.rightChild);
            if (need != null)
                return need;
        }
        return null;
    }
}