import java.util.Iterator;
import java.util.List;


public class HumanIterator implements Iterator<Human> {

    private int index;
    private List<Human> listHuman;

    public HumanIterator(List<Human> listHuman) {
        this.listHuman = listHuman;
    }


    @Override
    public boolean hasNext() {
        return listHuman.size() > index;
    }

    @Override
    public Human next() {
        return listHuman.get(index++);
    }
    
        
 

}
