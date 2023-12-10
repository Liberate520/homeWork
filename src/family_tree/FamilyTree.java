package family_tree;

import human.Gender;
import human.SortByAgeComparator;
import human.FamilyItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyItem> implements Serializable, Iterable<E> {
    private static final long serialVersionUID = 1L;
    private long countPeople;
    private List<E> familyTree;

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
                    sb.append("Id:" + human.getId() + " " + human.getName() + " Возраст: " + human.getAge());
                    if(human.getGender().equals(Gender.Mail)){
                        sb.append(" " + "Мужчина" + "\n");
                    } else {
                        sb.append(" " + "Женщина" + "\n");
                    }
                    if(human.getChild() != null){
                        sb.append("Дети: " +"\n"+ human.getChild() +  "\n");
                    }
            }
        }
        return sb.toString();
    }
    public void sortByName(){
        Collections.sort(familyTree,new SortByAgeComparator<>());
    }

    public void sortByAge(){
        Collections.sort(familyTree,new SortByAgeComparator<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(familyTree);
    }
}
