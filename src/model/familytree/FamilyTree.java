package model.familytree;
import model.human.Human;
import model.human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem> implements Serializable, Iterable<T> {
    private List<T> list;

    public FamilyTree() {
        this.list = new ArrayList<>();
    }

    public boolean addHumanToList(T t) {
        if (this.list.size() < 1 || !(this.list.contains(t))) {
            return this.list.add(t);
        }
        return false;
    }

    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T t : this.list) {
            stringBuilder.append(t.getGeneralInfo()).append("\n");
        }
        return stringBuilder.toString();
    }

    public Integer getSizeOfFamilyTree() {
        return this.list.size();
    }

    public boolean deleteHumanFromFamilyTree(Integer id) {
        Human humanToDelete = null;
        for(T t: this.list) {
            if (id.equals(t.getId())) {
                humanToDelete = (Human) t;
            }
        }
        System.out.println(humanToDelete.toString());
        return this.list.remove(humanToDelete);
    }


    @Override
    public Iterator<T> iterator() {
        return new HumanIterator(list);
    }

    public void sortByName() {

    }

    public void sortByAge() {

    }

    public void sortById() {

    }
}
