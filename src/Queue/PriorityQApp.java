package Queue;

public class PriorityQApp {
    public static void main(String[] args) {
        PriorityQ priorityQ = new PriorityQ(5);

        priorityQ.insert(30);
        priorityQ.insert(50);
        priorityQ.insert(10);
        priorityQ.insert(40);
        priorityQ.insert(20);

        while (!priorityQ.isEmpty()) {
            System.out.print(priorityQ.remove() + " ");
        }
    }
}
