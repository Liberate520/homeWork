import java.util.Iterator;
import java.util.List;

public class IterableHuman implements Iterator<Human> {
    private int index;
    private List<Human> humanlist;

    public IterableHuman(List<Human> humanlist) {
        this.humanlist = humanlist;
    }

    @Override
    public boolean hasNext() {
        return index < humanlist.size();
    }

    @Override
    public Human next() {
        return humanlist.get(index++);
    }

    // public void SortByName(){
    //     humanlist.getHumanlist().sort();
    // }

}
