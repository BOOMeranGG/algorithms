package recoursive;

/**
 * Алгоритм решения Ханойской башни
 */
public class HanoiTower {
    static int nDisks = 3;

    public static void main(String[] args) {
        //long t1 = System.currentTimeMillis();
        doAnswer(nDisks, 'A', 'B', 'C');
        //long t2 = System.currentTimeMillis();
        //System.out.println("Time: " + (t2 - t1) + " ms.");
    }

    public static void doAnswer(int top, char from, char inter, char to) {
        if (top == 1)
            System.out.println("Disk 1 from " + from + " to " + to);
        else {
            doAnswer(top - 1, from, to, inter);                                 //from-->inter
            System.out.println("Disk " + top + " from " + from + " to " + to);
            doAnswer(top - 1, inter, from, to);                                 //inter-->to
        }
    }
}
