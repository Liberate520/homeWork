package tree;

import human.Gender;
import human.Human;
import tree.itrator.TreeIterable;

import java.io.Serializable;
import java.util.*;


public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> familyList;

    public Iterator<Human> iterator() {
        return new TreeIterable(familyList);
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> familyList) {
        this.familyList = familyList;
    }

    public void add(Human hum) {
        if (!familyList.contains(hum)) {
            familyList.add(hum);
            addToMother(hum);
            addToFather(hum);
            addToChild(hum);
        }
    }

    public void weading(Human hum1, Human hum2) {
        hum1.setSpouse(hum2);
        hum2.setSpouse(hum1);
    }

    public void divorce(Human human) {
        human.getSpouse().addOldSpouse(human);
        human.addOldSpouse(human.getSpouse());
    }

    private void addToMother(Human human) {
        if (human.getMother() != null) human.getMother().addChild(human);
    }

    private void addToFather(Human human) {
        if (human.getFather() != null) human.getFather().addChild(human);
    }

    private void addToChild(Human human) {
        for (Human child : human.getChildrenList()) {
            if (human.getgGender() == Gender.Man) child.setFather(human);
            else child.setMother(human);
        }
    }

    public String getInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append("В дерево добавлено: ");
        sb.append(familyList.size());
        sb.append(" человек \n");
        for (Human human : familyList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        Collections.sort(familyList);
    }

    public void sortByAge() {
        familyList.sort(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o2.getAge() - o1.getAge();
            }
        });
    }


}
