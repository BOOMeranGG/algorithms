package Other.calculateString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Calculator calculator = new Calculator();
        double answer = calculator.calculate(str);

        System.out.println("Результат вычисления = " + answer);
    }

    public double calculate(String str) {
        StringBuilder postfix = new StringBuilder();
        List<String> postfixList = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        int i = 0;

        while (i < str.length()) {
            if (!isSign(str, i)) {                                      //Следующий элемент - число
                postfixList.add(Integer.toString(getNum(str, i)));
                while (i < str.length() && !isSign(str, i))             //Прокручиваем строку до знака
                    i++;
                continue;
            }
            if (str.charAt(i) == '(') {                                 //Если '(' - заносим в стек
                stack.push('(');
                i++;
                continue;
            }
            if (str.charAt(i) == ')') {                                 //Если ')'
                while (!stack.empty()) {                                //Пока в стеке остаются элементы
                    char sign = stack.pop();                            //Извлекаем элемент
                    if (sign == '(') {                                  //Если это (, то выходим
                        continue;
                    } else {                                            //Иначе, записываем в выходную строку
                        postfixList.add(sign + "");
                    }
                }
            }

            if (isSign(str, i)) {                                       //Если оператор
                char opThis = str.charAt(i);
                if (stack.empty()) {                                    //Если стек пуст, заносим элемент
                    stack.push(opThis);
                    i++;
                    continue;
                } else {                                                //Если оператор и стек не пуст
                    while (!stack.empty()) {
                        char opTop = stack.pop();                      //Взять элемент из стека
                        if (opTop == '(') {                             //Если скобка, то занести элемент в стек
                            stack.push(opTop);
                            break;
                        } else {                                        //Иначе
                            if (!isFirstMinorPriority(opTop, opThis)) {   //Если opTop >= opThis
                                postfixList.add(opTop + "");
                            } else {                                    //Если opTop < opThis
                                stack.push(opTop);
                                break;
                            }
                        }
                    }
                    //WARNING! AHTUNG!
                    stack.add(opThis);
                    i++;
                }
            }
        }

        while (!stack.empty()) {                                        //Конец входных данных
            char ch = stack.pop();                                      //КОСТЫЛЬ(НАПОМИНАНИЕ О БАГЕ) EXAMPLE: 2+((3*4))
            if (ch != ')')
                postfixList.add(ch + "");
        }
        for (int j = 0; j < postfixList.size(); j++) {
            postfix.append(postfixList.get(j));
        }
        System.out.println(postfix);
        return 1;
    }

    /**
     * Метод возвращает true, если указанный символ в строке - оператор
     * @param str   - исходная строка
     * @param i     - символ, который надо проверить
     * @return      - если вернул false, значит цифра
     */
    private boolean isSign(String str, int i) {
        char ch = str.charAt(i);
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/'
                                   || ch == '(' || ch == ')')
            return true;
        return false;
    }

    /**
     * Метод возвращает число, начиная с текущего символа и до того,
     * пока не натолкнётся на оператор +, -, *, /, (, )
     * @param str   - исходная строка
     * @param i     - символ, с которого берём число
     */
    private int getNum(String str, int i) {
        StringBuilder s = new StringBuilder();

        while (i < str.length() && !isSign(str, i)) {
            s.append(str.charAt(i));
            i++;
        }
        return Integer.parseInt(s.toString());
    }

    /**
     * @return  - Возвращает false, если приоритет у первого оператора
     * больше либо равен, по сравнению со вторым
     */
    private boolean isFirstMinorPriority(char first, char second) {
        if ((first == '+' || first == '-') && (second == '*' || second == '/'))
            return true;
        return false;
    }
}
