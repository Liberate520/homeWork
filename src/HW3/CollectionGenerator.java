package HW3;

import java.util.ArrayList;
import java.util.Random;

public class CollectionGenerator {
    public static ArrayList<Integer> integers(int size){
        ArrayList <Integer> list = new ArrayList();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(20));
        }
        return list;
    }
}
