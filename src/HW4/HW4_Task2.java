package HW4;

import java.util.LinkedList;
import java.util.Queue;

public class HW4_Task2 {
/// Не знаю, на сколько это правильно с точки зрения поставленной задачи.
    static boolean enqueue(Queue<Integer> list, Integer node){
        return list.offer(node);
    }
    static Integer dequeue(Queue<Integer> list){
        return list.poll();
    }

    static Integer first(Queue<Integer> list){
        return list.peek();
    }

    public static void main(String[] args) {
        Queue<Integer> testlist = new LinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
                enqueue(testlist,i);
            System.out.println("["+ i +"] "+ "added to list, current size: " + testlist.size());
        }
        System.out.println("Initial list: " + testlist);

        System.out.println(testlist);
        Integer firstnode1 = dequeue(testlist);
        System.out.println("list after dequeue(); : " + testlist);
        System.out.println("dequeue(); element : " + firstnode1);
        Integer firstnode2 = first(testlist);
        System.out.println("list after first(); : " + testlist);
        System.out.println("first(); element : " + firstnode2);
    }

}
