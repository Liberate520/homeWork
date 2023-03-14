package sorted;

import java.util.ArrayList;
import java.util.Iterator;
import genealogicalTree.*;

public class HumanIteratir<T> implements Iterator<T> {
        
    private int index;
    private ArrayList<T> familyList;

    public HumanIteratir(ArrayList<T> familyList){
        this.familyList = familyList;
    }

    @Override
    public boolean hasNext() {
        return familyList.size() > index;
    }
    
    @Override
    public T next() {
        return familyList.get(index++);
    }
}
