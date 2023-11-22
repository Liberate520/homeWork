package Family_Tree.Tree;

import Family_Tree.Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{
    private long humanId;
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

//    public FamilyTree() {
//        humanList = new ArrayList<>();
//    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humanId++);

            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public List<Human> getByName(String name) {
        List<Human> result = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result;
    }

    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChildren(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" людей: \n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        humanList.sort(new FamilyTreeComparatorByName());
    }

    public void sortByBirthday(){
        humanList.sort(new FamilyTreeComparatorByBirthday());
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public Iterator<Human> iterator(){
        return new FamilyTreeIterator(humanList);
    }
}
