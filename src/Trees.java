import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Trees implements Serializable, Iterable<Human> {
    private List<Human> humanlist;

    public Trees(List<Human> humanlist) {
        this.humanlist = humanlist;
    }

    public Trees() {
        this(new ArrayList<>());
    }

    public List<Human> getHumanlist() {
        return humanlist;
    }

    public void sethumanlist(List<Human> humanlist) {
        this.humanlist = humanlist;
    }

    public void add_human(Human human) {
        humanlist.add(human);
    }

    @Override
    public String toString() {
        return "Trees [humanlist=" + humanlist + "]";
    }

    @Override
    public Iterator<Human> iterator() {
        return new IterableHuman(humanlist);
    }



}
