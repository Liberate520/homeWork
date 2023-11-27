package family_tree;

import humans.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            addingChildren(human);
            addingParents(human);
        }

    }

    /**
     * Добавление родителям детей:
     * Если у указанного человека есть родители,
     * то этим родителям будет добавлен указанный человек,
     * как ребенок.
     *
     * @param human ребенок
     */
    private void addingChildren(Human human) {
        for (Human parent : human.getParents()) {
            parent.setChildren(human);
        }
    }

    /**
     * Добавление ребенку родителей:
     * Если у указанного человека есть дети,
     * то этим детям будет добавлен указанный человек,
     * как родитель.
     * @param human родитель
     */
    private void addingParents(Human human) {
        for (Human child : human.getChildren()) {
            child.getParents();
        }
    }

    public Object getById(Integer id) {
        for (Human human : humanList) {
            if (human.getId().equals(id)) {
                return human;
            }
        }
        return humanList;
    }

    public Object getByName(String name) {
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return humanList;
    }

    public StringBuilder getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    @Override
    public String toString() {
        return "Список людей: \n" + getHumanListInfo();
    }


}
