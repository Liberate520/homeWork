package family_tree.ftree;

import family_tree.person.Person;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<P extends Person> implements Iterator<P> {
    private int index;
    private List<P> relations;

    public FamilyTreeIterator(List<P> relations){
        this.relations = relations;
    }

    @Override
    public boolean hasNext(){
        return relations.size() > index;
    }

    @Override
    public P next(){
        return relations.get(index++);
    }
}
