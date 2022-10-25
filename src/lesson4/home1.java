package lesson4;

// import java.util.Collections;
import java.util.LinkedList;

public class home1 {
    // Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println(reverseList(list));
        // Collections.reverse(list);
        // System.out.println(list);
    }

    static LinkedList<Integer> reverseList(LinkedList<Integer> list) {
        LinkedList<Integer> nlist = new LinkedList<>();
        int length = list.size();
        for (int i = 0; i < length; i++) {
            nlist.add(list.pollLast());
        }
        return nlist;
    }
}
