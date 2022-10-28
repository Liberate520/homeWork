package lesson4;

import java.util.LinkedList;

public class home2 {

    // Реализуйте очередь с помощью LinkedList со следующими методами: 
    // enqueue() - помещает элемент в конец очереди, 
    // dequeue() - возвращает первый элемент из очереди и удаляет его, 
    // first() - возвращает первый элемент из очереди, не удаляя.

    static Integer first(LinkedList<Integer> list){
        return list.peek();
    }

    static LinkedList<Integer> enqueue(LinkedList<Integer> list) {
        int num = list.getFirst();
        list.addLast(num);
        list.removeFirst();
        return list;
    }
    
    static Integer dequeue(LinkedList<Integer> list){
        return list.poll();
    }

    public static void main(String[] args) {
        LinkedList<Integer> testlist = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
                testlist.add(i);
        }
        System.out.println("Initial list: " + testlist + "\n");
        System.out.println("list before dequeue(); : " + testlist);
        System.out.println("dequeue() : " + dequeue(testlist));
        System.out.println("list after dequeue() : " + testlist + "\n");
        System.out.println("list before first(); : " + testlist);
        System.out.println("first() : " + first(testlist));
        System.out.println("list after first() : " + testlist + "\n");
        System.out.println("enqueue() : " + enqueue(testlist));
    }
}
