import java.util.Iterator;
import java.util.List;


public class HumanIterator<T extends UserParametrized> implements Iterator<T> {

    private int index;
    private List<T> listHuman;

    public HumanIterator(List<T> listHuman) {
        this.listHuman = listHuman;
    }


    @Override
    public boolean hasNext() {
        return listHuman.size() > index;
    }

    @Override
    public T next() {
        return listHuman.get(index++);
    }
    
        
 

}
