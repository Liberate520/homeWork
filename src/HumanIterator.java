import java.util.Iterator;
import java.util.List;

class HumanIterator<T extends Individual> implements Iterator <T>{
    private int index;
    private List<T> humans;

    public HumanIterator (List<T> humans){
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {            
        return humans.size()>index;
    }

    @Override
    public T next() {            
        return humans.get(index++);
    }
}
