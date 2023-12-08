package tree;

import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import human.сomparators.ComparatorByAge;
import human.сomparators.ComparatorByName;


public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    private int id;
    private String family;
    private List<E> membersList;
    private int memberId = 1;


    public FamilyTree(String family) {
        this.family = family;
        membersList = new ArrayList<>();
    }

    public void addMembers(E human) {
        human.setId(memberId++);
        membersList.add(human);
    }

    public String getFamilyInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список родословной:\n");
        for (E human: membersList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void sortByAge() {
        membersList.sort(new ComparatorByAge<>());

    }

    public void sortByName() {
        membersList.sort(new ComparatorByName<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(membersList);
    }


    @Override
    public String toString() {
    return getFamilyInfo();
    }
}