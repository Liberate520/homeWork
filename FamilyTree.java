package HW_4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {

    private List<T> humanList;

    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<T> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<T> humanList) {
        this.humanList = humanList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : humanList) {
            sb.append(item.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void addHuman(T human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
        }
    }

    public void removeHuman(T human) {
        if (human.getMother() != null){
            human.getMother().getChildren().remove(human);
        }
        if (human.getFather() != null) {
            human.getFather().getChildren().remove(human);
        }
        humanList.remove(human);
    }


    public T getByName(String name) {
        for (T human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyIterator(humanList);
    }

}
