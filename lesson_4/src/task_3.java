import java.util.LinkedList;

// Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке.
// Используйте итератор
public class task_3 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < 50; i++) {
            ll.add(i);
        }
        int length = ll.size();
        for (int i = 0; i < length; i++) {
            sum += ll.get(i);
        }
        System.out.println(ll);
        System.out.println(sum);
    }
}
