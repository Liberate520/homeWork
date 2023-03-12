package sorted;

import java.util.ArrayList;
import java.util.Iterator;
import genealogicalTree.*;

public class HumanIteratir implements Iterator<Human> {
        
    private int index;
    private ArrayList<Human> familyList;

    public HumanIteratir(ArrayList<Human> familyList){
        this.familyList = familyList;
    }

    @Override
    public boolean hasNext() {
        return familyList.size() > index;
    }
    
    @Override
    public Human next() {
        return familyList.get(index++);
    }
}
