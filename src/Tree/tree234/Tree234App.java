package Tree.tree234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree234App {
    public static void main(String[] args) throws IOException {
        long value;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Tree234 tree = new Tree234();

        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(30);
        tree.insert(70);

        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, or find: ");
            char choice = r.readLine().charAt(0);

            switch (choice) {
                case 's':
                    tree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = Integer.parseInt(r.readLine());
                    tree.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = Integer.parseInt(r.readLine());
                    int found = tree.find(value);
                    if (found != -1)
                        System.out.println("Fount " + value);
                    else
                        System.out.println("Could not find " + value);
                    break;
                default:
                    System.out.println("Invalid entry\n");
            }
        }
    }
}
