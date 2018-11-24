package stack;

import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StackInt stack = new StackInt(str.length());

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            stack.push((int) ch);
        }

        while (!stack.isEmpty()) {
            System.out.print((char) stack.pop());
        }
    }
}
