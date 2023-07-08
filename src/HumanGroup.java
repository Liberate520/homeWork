import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanGroup implements Iterable<Human>, Serializable {
    private List<Human> humans;
    HumanGroup(){
        humans = new ArrayList<>();
    }

    public void add(Human h){
        humans.add(h);
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);   //return humans.iterator();
    }
}
