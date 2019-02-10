package Heap.BinaryHeapBaseOnArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Макс-куча на основе массива(списка). Максимальный элемент
 * всегда находится в индексе 0.
 *
 * Если индекс текущего элемента i, то его левый ребёнок
 * имеет индекс i * 2 + 1, а правый - i * 2 + 2. Добавляем
 * лишнюю единицу, т.к. в массиве отсчёт начинается с нуля.
 * Предок же текущего элемента имеет индекс (i - 1) / 2.
 * Минус единица по той же прицине.
 */
public class BinaryHeap {
    private List<Integer> list;

    public BinaryHeap() {
        list = new ArrayList<>();
    }

    /**
     * Добавляем элемент в самую нижнюю и крайнюю правую
     * ячейку(последний индекс). Чтобы восстановить свойство кучи
     * (каждый родитель больше либо равен своих детей), просеиваем
     * текущий элемент вверх.
     *
     * Пока мы не дошли до листового элемента И
     * родитель меньше своего ребёнка(просеиваемого элемента),
     * мы меняем узлы местами.
     * @param x - элемент, который добавляем в кучу
     */
    public void insert(int x) {
        list.add(x);
        int child = list.size() - 1;
        int parent = (child - 1) / 2;

        while (child > 0 && list.get(parent) < list.get(child)) {
            int temp = list.get(parent);
            list.set(parent, list.get(child));
            list.set(child, temp);

            child = parent;
            parent = (child - 1) / 2;
        }
    }

    /**
     * Метод возвращает(и удаляет из кучи) наибольший элемент.
     * Max-элемент всегда находится под индексом 0.
     * Меняем максимальный элемент с последним в массиве. Далее надо просеять
     * вниз элемент, который теперь находится в корне, чтобы сохранить свойство
     * макс-кучи(каждый родитель больше либо равен своих детей).
     *
     * Идём в цикле, пока существует левый ребёнок И пока
     * перемещаемый элемент меньше левого ИЛИ пока существует правый
     * ребёнок И перемещаемый элемент меньше правого. В таких случаях,
     * мы меняем местами просеиваемый элемент с МАКСИМАЛЬНЫЙ по значению
     * ребёнком.
     * @return  - наибольший элемент в куче.
     */
    public int extractMax() {
        int result = list.get(0);
        int lastElement = list.get(list.size() - 1);
        list.set(0, lastElement);
        list.remove(list.size() - 1);
        int parent = 0;
        int leftChild = 1;
        int rightChild = 2;

        while (leftChild < list.size() && (list.get(parent) < list.get(leftChild)
                || (rightChild < list.size() && list.get(parent) < list.get(rightChild)))) {
            int temp = list.get(parent);
            if ((rightChild >= list.size()) || list.get(leftChild) > list.get(rightChild)) {     //Наибольший левый ребёнок
                list.set(parent, list.get(leftChild));
                list.set(leftChild, temp);
                parent = leftChild;
            } else {                                                                            //Наибольший правый ребёнок
                list.set(parent, list.get(rightChild));
                list.set(rightChild, temp);
                parent = rightChild;
            }
            leftChild = parent * 2 + 1;
            rightChild = leftChild + 1;
        }
        return result;
    }
}
