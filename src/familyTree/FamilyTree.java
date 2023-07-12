package familyTree;

import human.Human;
import human.cmp.HumanComparatorByAge;
import human.cmp.HumanComparatorByBirthDate;
import human.cmp.HumanComparatorByFullName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private int idHuman;
    private List<Human> humanList;

    //    public FamilyTree() { humanList = new ArrayList<>(); };
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean addHuman(Human human) {
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

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public Human getByName(String surname, String name, String patronymic) {
        for (Human human : humanList) {
            if ((human.getSurname().equals(surname)) &&
                    (human.getName().equals(name)) &&
                    (human.getPatronymic().equals(patronymic))) {
                return human;
            }
        }
        return null;
    }

    public String getFamilyTreeInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("Список всех учтенных родственников в семейном дереве:\n");
        for (Human human : humanList) {
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
    public Iterator<Human> iterator(){
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
