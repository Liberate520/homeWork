package family_tree.ftree;

import family_tree.person.Person;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Person> {
    private int index;
    private List<Person> relations;

    public FamilyTreeIterator(List<Person> relations){
        this.relations = relations;
    }

    @Override
    public boolean hasNext(){
        return relations.size() > index;
    }

    @Override
    public Person next(){
        return relations.get(index++);
    }
}
