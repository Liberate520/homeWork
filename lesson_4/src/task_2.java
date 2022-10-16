import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
// Реализуйте очередь с помощью LinkedList со следующими методами: 
// enqueue() - помещает элемент в конец очереди, 
// dequeue() - возвращает первый элемент из очереди и удаляет его, 
// first() - возвращает первый элемент из очереди, не удаляя.

public class task_2 {
    public static void main(String[] args) {
        myLinkedList ll = new myLinkedList();

        ll.enqueue(5);
        ll.enqueue(8);
        System.out.println(ll.first());
        System.out.println(ll.first());
        System.out.println(ll.first());
        System.out.println(ll.dequeue());
        // System.out.println(ll.dequeue()); - Exception
    }
}
