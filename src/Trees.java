import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Trees<T extends Human> implements Iterable<T> {
    private List<T> humanlist;

    public Trees(List<T> humanlist) {
        this.humanlist = humanlist;
    }

    public Trees() {
        this(new ArrayList<>());
    }

    public List<T> getHumanlist() {
        return humanlist;
    }

    public void sethumanlist(List<T> humanlist) {
        this.humanlist = humanlist;
    }

    public void add_human(T human) {
        humanlist.add(human);
    }

    @Override
    public String toString() {
        return "Trees [humanlist=" + humanlist + "]";
    }

    @Override
    public Iterator<T> iterator() {
        return new IterableHuman<T>(humanlist);
    }

    public void SortByName() {
        Collections.sort(humanlist);
    }

    public void SortByBirth() {
        Collections.sort(humanlist, new HumanComparatorByBirth<T>());
    }

}
