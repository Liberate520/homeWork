import java.util.LinkedList;

// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который
// вернет “перевернутый” список.

/**
 * task_1
 */
public class task_1 {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < 100; i++) {
            ll.add(num++);
        }
        System.out.println(reverse(ll));
    }

    static LinkedList reverse(LinkedList ll) {
        LinkedList newll = new LinkedList();
        int length = ll.size();
        for (int i = 0; i < length; i++) {
            newll.add(ll.pollLast().toString());
        }
        return newll;
    }
}