package FamilyTree.FamilyTree;

import FamilyTree.Comparator.SortByAge;
import FamilyTree.Comparator.SortByName;
import Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends EntityItem> implements Serializable, Iterable<E> {
    private List<E> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addToList(E human) {
        familyTree.add(human);
    }

    public void findByName(String name) {
        boolean flag = false;
        for (E member : familyTree) {
            if (member.getName().equalsIgnoreCase(name)) {
                flag = true;
                System.out.println(member);
            }
        }
        if (!(flag)) {
            System.out.println("Такого человека нет");
        }
    }

    public String getInfoFamilyTree() {
        StringBuilder info = new StringBuilder();
        for (E human : familyTree) {
            info.append(human);
            int length = human.getInfo().length();
            info.append("\n");
            String str = "";
            for (int i = 0; i < length; i++) {
                str += "-";
            }
            info.append(str);
            info.append("\n");
        }
        return info.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyMemberIterator<>(familyTree);
    }

    public void sortByName() {
        familyTree.sort(new SortByName());
    }
    public void sortByAge(){
        familyTree.sort(new SortByAge());
    }
}