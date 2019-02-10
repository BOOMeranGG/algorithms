package Heap.BinaryHeapBaseOnArray;

import java.util.Scanner;

/**
 * Первая строка входа содержит число операций 1≤n≤10^5. Каждая из последующих
 * n строк задают операцию одного из следующих двух типов:
 * Insert x, где 0 ≤ x ≤ 10^9 — целое число;
 * ExtractMax.
 * Первая операция добавляет число x в очередь с приоритетами,
 * вторая — извлекает максимальное число и выводит его.
 * CORRECTLY!
 */
public class PriorityQueueApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryHeap heap = new BinaryHeap();
        int n = Integer.parseInt(sc.nextLine());
        String[] instructions = new String[n];

        for (int i = 0; i < n; i++) {
            instructions[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            String[] s = instructions[i].split(" ");
            if (s.length == 1) {                                //Команда ExtractMax
                System.out.println(heap.extractMax());
            } else {                                            //Команда Insert
                heap.insert(Integer.parseInt(s[1]));
            }
        }
    }
}
