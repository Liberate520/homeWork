package family_tree.model.tree;



import family_tree.model.human.comparators.HumanComparatorByAge;
import family_tree.model.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree<E extends SentientEntity<E>> implements Serializable, Iterable<E>, Group<E> {
    private int memberId;
    private List<E> family;

    public Tree() {
        this.family = new ArrayList<>();
    }

    @Override
    public void addFamilyMember(E member){
        if (!(member == null)
                && !family.contains(member)){
            family.add(member);
            member.setId(memberId++);
        }
    }

    @Override
    public E getFamilyMember(int id){
        return family.get(id);
    }

    @Override
    public int getFamilySize(){
        return family.size();
    }

    @Override
    public void clearFamily(){
        family.clear();
    }

    @Override
    public void sortByName() {family.sort(new HumanComparatorByName<E>());}

    @Override
    public void sortByAge() {family.sort(new HumanComparatorByAge<E>());}
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(family);
    }
}
