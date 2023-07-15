package FamilyTree.model.Tree;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T> implements Iterable<T>{
    private List<T> list;
    private long id;

    public FamilyTree(int id){
        list = new ArrayList<>();
        this.id = id;
    }
    public void addHuman(T human){
        list.add(human);
    }
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
