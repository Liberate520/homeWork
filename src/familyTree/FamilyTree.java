package familyTree;

import human.Human;
import human.cmp.HumanComparatorByAge;
import human.cmp.HumanComparatorByBirthDate;
import human.cmp.HumanComparatorByFullName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private int idHuman;
    private List<E> humanList;

    //    public FamilyTree() { humanList = new ArrayList<>(); };
    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean addHuman(E human) {
        human.setId(idHuman++);
//        humanList.add(human);
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public E getByName(String surname, String name, String patronymic) {
        for (E human : humanList) {
            if ((human.getSurname().equalsIgnoreCase(surname)) &&
                    (human.getName().equalsIgnoreCase(name)) &&
                    (human.getPatronymic().equalsIgnoreCase(patronymic))) {
                return human;
            }
        }
        return null;
    }

    public String getFamilyTreeInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("Список всех учтенных родственников в семейном дереве:\n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        sb.append("Всего учтенных родственников в семейном дереве: ");
        sb.append(humanList.size() + "\n");

        return sb.toString();
    }

    @Override
    public String toString() {
        return getFamilyTreeInfo();
    }

    @Override
    public Iterator<E> iterator(){
        return new HumanIterator(humanList);
    }
    public void sortByFullName() {
        humanList.sort(new HumanComparatorByFullName());
    }
    public void sortByBirthDate(){
        humanList.sort(new HumanComparatorByBirthDate());
    }
    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }
}
