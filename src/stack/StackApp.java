package stack;

public class StackApp {
    public static void main(String[] args) {
        StackInt stack = new StackInt(10);
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while (!stack.isEmpty()) {
            long val = stack.pop();
            System.out.print(val + " ");
        }
    }
}
