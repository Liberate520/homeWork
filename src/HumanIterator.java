import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {

    private List<Human> humanList;
    private int index;

    public HumanIterator(List<Human> studentList) {
        this.humanList = studentList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
