package HW4;

import java.util.Collections;
import java.util.LinkedList;

public class HW4_Task1 {



    public static void main(String[] args) {
        var list= new LinkedList<Integer>();
        int num = 10;

        for (int i = 0; i < num; i++) {
            list.add(i);
        }
        System.out.println("Initial List: " + list);

        Collections.reverse(list);
        System.out.println("Reversed List: " + list);






    }
}
