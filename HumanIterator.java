import java.util.Iterator;
import java.util.List;

class HumanIterator implements Iterator <Human>{
    private int index;
    private List<Human> humans;

    public HumanIterator (List<Human> humans){
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {            
        return humans.size()>index;
    }

    @Override
    public Human next() {            
        return humans.get(index++);
    }
}
