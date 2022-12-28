package gb.task_4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends LiveBeing> implements Serializable, IFamilyTree, Iterable<T> {
    private List<T> liveBeings;

    public FamilyTree() {
        this.liveBeings = new ArrayList();
    }

    @Override
    public List<T> getLiveBeings() {
        return this.liveBeings;
    }

    @Override
    public void addLiveBeing(LiveBeing liveBeing, LiveBeing father, LiveBeing mother) {
        if (father != null) {
            liveBeing.setFather((T) father);
            father.getChildren().add((T) liveBeing);
        }
        if (mother != null) {
            liveBeing.setMother((T) mother);
            mother.getChildren().add((T) liveBeing);
        }
        liveBeings.add((T) liveBeing);
    }

    public T findByName(String name) {
        for (T liveBeing : liveBeings) {
            if (liveBeing.getName() == name)
                return liveBeing;
        }
        return null;
    }

    public List<T> findAllByName(String name) {
        List<T> liveBeings = new ArrayList();
        for (T liveBeing : this.liveBeings) {
            if (liveBeing.getName() == name)
                liveBeings.add(liveBeing);
        }
        return liveBeings;
    }

    public void showAllInConsole() {
        for (T liveBeing : liveBeings) {
            System.out.println(liveBeing.toString());
        }
    }

    public void sortByName() {
        Collections.sort(this.liveBeings);
    }

    public void sortByDate() {
        Collections.sort(this.liveBeings, new TComparatorByDate());
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator(this.liveBeings);
    }
}
