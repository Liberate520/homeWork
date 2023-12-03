package model.tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.human.comparators.HumanComparatorByName;
import model.human.comparators.HumanComparatorBySurname;

public class FamilyTree <E extends TreeItem> implements Serializable, Iterable<E>{
    private List<E> humanList;

    public FamilyTree(int id) {
        humanList = new ArrayList<>();
    }

    public void addHuman(E human){
        human.setId(humanList.size());
        humanList.add(human);
    }

    public E findInTree(int id) {
        for (E member : humanList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public String infoById(int id) {
        StringBuilder sb = new StringBuilder("Id - ");
        sb.append(id).append("\n").append("\n");
        E human = findInTree(id);
        if (human != null) {
            sb.append("Фамилия: ").append(human.getSurname() + "\n");
            sb.append("Имя: ").append(human.getName() + "\n");
            if (human.getParents() != null) {
                sb.append(human.getParents() + "\n");
            }
            if (human.getChildren() != null) {
                sb.append(human.getChildren() + "\n");
            }
            return sb.toString();
        }
        return "Данных нет.";
    }


    public void setHumanList(List<E> humanList) {
        this.humanList = humanList;
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortBySurname() {
        humanList.sort(new HumanComparatorBySurname<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

}