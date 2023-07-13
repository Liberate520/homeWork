package FamilyTree.Tree;



import FamilyTree.Human.Human;
import FamilyTree.Human.comparators.sortByAge;
import FamilyTree.Human.comparators.sortByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T> implements Iterable<T>{
    private long id;
    private List<T> humanList = new ArrayList<>();

    public FamilyTree(long id) {
        this.id = id;
    }

    public void addHuman(T human){
        humanList.add(human);
    }

    public void sortByAge() {
        humanList.sort(new sortByAge());
    }

    public void sortByName(){
        humanList.sort(new sortByName());
    }
    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
    }

}
