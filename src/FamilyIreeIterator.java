import java.util.Iterator;
import java.util.List;

public class FamilyIreeIterator implements Iterator<Human> {
    private List<Human> humanList;
    private int index;
    public FamilyIreeIterator(List<Human> humanList) {

        this.humanList = humanList;
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
