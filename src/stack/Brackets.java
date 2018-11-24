package stack;

import java.util.Scanner;

/**
 * Класс проверяет, есть ли у каждой открывающейся скобки, её пара-закрывающая
 * Откровающие скобки ближе к концу строки закрываются раньше тех, которые
 * расположены ближе к началу: a{b(c]d}e -  не правильно, ] не соответствует (
 */
public class Brackets {
    public static StackInt stack;

    public static void main(String[] args) {
        if (checkBrackets())
            System.out.println("Правильно");
        else
            System.out.println("Не правильно");
    }

    public static boolean checkBrackets() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        stack = new StackInt(str.length());

        for (int i = 0; i < str.length() ; i++) {
            char ch = str.charAt(i);
            switch(ch) {
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    break;

                case '}':
                case ')':
                case ']':
                    if (!stack.isEmpty()) {
                        char ch2 = (char) stack.pop();
                        if ((ch == '}' && ch2 == '{') ||
                           (ch == ']' && ch2 == '[')  ||
                           (ch == ')' && ch2 == '('))
                                continue;
                        else
                            return false;
                    }
                    break;
            }
            if (!stack.isEmpty())
                return false;
        }
       return true;
    }
}
