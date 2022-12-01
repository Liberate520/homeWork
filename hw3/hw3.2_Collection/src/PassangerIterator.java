import java.util.List;
import java.util.Iterator;

public class PassangerIterator implements Iterator<Passanger> {

    private List<Passanger> listPassanger;
    private int index = 0;

    public PassangerIterator(List<Passanger> listPassanger) {
        this.listPassanger = listPassanger;
    }

    @Override
    public boolean hasNext() {
        return index < listPassanger.size();
    }

    @Override
    public Passanger next() {
        return listPassanger.get(index++);
    }
} 
    

