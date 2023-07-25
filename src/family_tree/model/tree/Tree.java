package family_tree.model.tree;


import family_tree.model.human.Gender;
import family_tree.model.human.comparators.HumanComparatorByAge;
import family_tree.model.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree<E extends SentientEntity<E>> implements Serializable, Iterable<E> {
    private int memberId;
    private List<E> family;

    public Tree() {
        this.family = new ArrayList<>();
    }

    public void addFamilyMember(E member){
        if (!(member == null)
                && !family.contains(member)){
            family.add(member);
            member.setId(memberId++);
        }
    }
    public E getFamilyMember(int id){
        return family.get(id);
    }

    public int getFamilySize(){
        return family.size();
    }
    public void clearFamily(){
        family.clear();
    }

    public void sortByName() {family.sort(new HumanComparatorByName<E>());}

    public void sortByAge() {family.sort(new HumanComparatorByAge<E>());}
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(family);
    }
}
