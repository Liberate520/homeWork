package familyTree.View;

import java.util.List;

public class printListWithEOL<E> {
    public void print(List<E> list){
        for ( E item : list) {
            System.out.println(item.toString() + "\n");
        }
    }
}
