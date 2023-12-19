package model.family_tree;

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
            System.out.println("Человек добавлен в древо!");
            System.out.println();
            return true;
        }
        System.out.println("Возникла ошибка при добавлении человека в древо");
        System.out.println();
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!(familyTree.isEmpty())) {
            for (E human : familyTree) {
                    sb.append(human.toString());
                    if(!human.setChild().isEmpty()){
                        sb.append("Дети: " +"\n"+ human.setChild());
                    }
                    sb.append("\n");
            }
        }
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
