package stack;

public class StackInt {
    private int maxSize;            //Размер массива
    private long[] stackArray;
    private int top;                //Вершина стека

    public StackInt(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;                   //Пока что элементов в стеке нет
    }

    public void push(long k) {      //Добавление элемента в стек
        stackArray[++top] = k;
    }

    public long pop() {             //Извлечение элемента
        return stackArray[top--];
    }

    public long peek() {            //Возвращает верхний элемент, не удаляя его из стека
        return stackArray[top];
    }

    public boolean isEmpty() {      //Возвращает true, если стек пуст
        return (top == -1);
    }

    public boolean isFull() {       //Возвращзает true, если стек заполнен
        return (top == maxSize - 1);
    }

}
