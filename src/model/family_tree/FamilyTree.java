package model.family_tree;

import model.human.Gender;
import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyItem<E>> implements Serializable, Iterable<E> {
    private static final long serialVersionUID = 1L;
    private long countPeople;
    public List<E> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public boolean addHumanInTree(E human) {
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            human.setId(countPeople++);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!(familyTree.isEmpty())) {
            for (E human : familyTree) {
                    sb.append("Id:" + human.getId() + " " + human.getName() + " Возраст: " + human.getAge() + " ");
                    if(!human.getChild().isEmpty()){
                        sb.append("Дети: " +"\n"+ human.getChild());
                    }
                    sb.append("\n");
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    public void sortByName(){
        familyTree.sort(new SortByAgeComparator<>());
    }

    public void sortByAge(){
        familyTree.sort(new SortByAgeComparator<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(familyTree);
    }
}
