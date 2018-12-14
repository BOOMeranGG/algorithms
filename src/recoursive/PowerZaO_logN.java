package recoursive;

/**
 * Вычисления числа в любой степени за O(logN)
 */
public class PowerZaO_logN {
    public static long recPower(long x, long y) {
        if (y == 0)
            return 1;
        if (y == 1)
            return x;
        if (y % 2 == 0)
            return recPower(x * x, y / 2);
        else
            return recPower(x * x, y / 2) * x;
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        System.out.println(x + " в степени " + y + " = " + recPower(x, y));
    }
}
