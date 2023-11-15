package family_Tree.familyTree;

import family_Tree.human.comparators.HumanComparatorByAge;
import family_Tree.human.comparators.HumanComparatorById;
import family_Tree.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    private List<E> humanList;
//    private int humanId;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public FamilyTree(List<E> humanList){
        this.humanList = humanList;
    }

    public void addHuman(E human){
        humanList.add(human);
    }

    public E getById (int id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanList) {
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append((humanList.size()));
        sb.append(" элементов: \n");
        for (E human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return getInfo();
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }

    public void sortById(){
        humanList.sort(new HumanComparatorById());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }

}
