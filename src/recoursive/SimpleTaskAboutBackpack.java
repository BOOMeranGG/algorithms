package recoursive;

import java.util.*;

/**
 * Задача о рюкзаке. Требуется заполнить рюкзак предметами
 * различного веса для достижения заданного суммарного веса.
 */
public class SimpleTaskAboutBackpack {
    private int[] items = {11, 8, 7, 6, 5};
    private int mainGoal = 20;
    private Stack<Integer> stack = new Stack<>();
    private boolean isFull = false;

    public static void main(String[] args) {
        SimpleTaskAboutBackpack t = new SimpleTaskAboutBackpack();
        t.doIt();
    }

    public void doIt() {
        find(mainGoal, 0);
        if (isFull) {
            System.out.print("Answer: ");
            while (!stack.isEmpty())
                System.out.print(stack.pop() + " ");
        } else
            System.out.println("Невозможно собрать!");
    }

    /**
     * Рекурсивный метод для решения задачи. Если суммарный вес достиг целевого,
     * то завершаем работу. Берём первый элемент. Вес остальных предметов должен
     * быть равен (цель - первый предмет). Далее последовательно перебираем комбинации
     * всех остальных предметов. Если новый предмет больше, чем сотавшаяся цель - его
     * не заносим в стек(рюкзак). Если ни одна из комбинаций не сработала, удаляем из
     * стека первый предмет и последовательно проходим по всем предметам.
     * @param goal - текущая цель по весу
     * @param key  - элемент, который мы хотим взять из текущего набора
     */
    public void find(int goal, int key) {
        if (isFull || isBackpackFull())                     //Вроде не нужно, но мб на некоторых данных
            return ;                                        //без этой проверки не будет работать/будет работать долго
        int item = items[key];
        if (item > goal)                                    //Если текущий предмет не влезает в рюкзак,
            return ;                                        //то мы его не берём
        stack.push(item);
        if (item == goal)                                   //Если рюкзак наполнен, то завершаем работу
            return ;

        for (int i = key + 1; i < items.length; i++) {      //Проходим по всем предметам
            find(goal - item, i);
            if (isFull || isBackpackFull())                 //Если рюкзак в какой-то из итераций наполнен,
                return ;                                    //то завершаем работу
        }
        stack.pop();                                        //Прошли все комбинации, удаляем предмет из стека
        if (stack.isEmpty() && key != items.length - 1) {   //Выполняется, если мы удалили первый элемент
            find(mainGoal, key + 1);                    //Тогда переходим ко второму и т.д.
        }
    }

    /**
     * Метод проверяет, наполнен ли рюкзак,
     * и ответ присваиевает isFull
     * @return - полный рюкзак или нет (нашли ответ, или ещё нет)
     */
    public boolean isBackpackFull() {
        if (isFull)
            return true;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        while (!stack.isEmpty()) {
            int k = stack.pop();
            sum += k;
            list.add(k);
        }
        if (list.size() > 0) {
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
        isFull = sum == mainGoal;
        return (isFull);
    }
}
