package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> peopleList;

    public FamilyTree() {
        this.peopleList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.peopleList.add(human);
    }

    public List<Human> getPeopleList() {
        return peopleList;
    }

    public List<Human> getChildren(Human human) {
        return human.getChildren();
    }

    public List<Human> getParents(Human human) {
        return human.getParents();
    }

    /**
     * функция getDescendants ищет потомков для
     * указанного персонажа
     * 
     * @param Human - получает объект персонажа
     * @return - возвращает список потомков
     */
    public List<Human> getDescendants(Human Human) {
        List<Human> descendants = new ArrayList<>();
        for (Human child : Human.getChildren()) {
            descendants.add(child);
            descendants.addAll(getDescendants(child));
        }
        return descendants;
    }

    /**
     * функция getAncestors ищет предков для
     * указанного персонажа
     * 
     * @param Human - получает объект персонажа
     * @return - возвращает список предков
     */
    public List<Human> getAncestors(Human Human) {
        List<Human> ancestors = new ArrayList<>();
        for (Human parent : Human.getParents()) {
            ancestors.add(parent);
            ancestors.addAll(getAncestors(parent));
        }
        return ancestors;
    }

    /**
     * функция getRelatives ищет родственные связи для
     * указанного персонажа
     * 
     * @param Human - получает объект персонажа
     * @return - возвращает список связей
     */
    public List<Human> getRelatives(Human Human) {
        List<Human> relatives = new ArrayList<>();
        relatives.addAll(getAncestors(Human));
        relatives.addAll(getDescendants(Human));
        return relatives;
    }

    public List<Human> searchByName(String name) {
        List<Human> result = new ArrayList<>();
        for (Human Human : peopleList) {
            if (Human.toString().contains(name)) {
                result.add(Human);
            }
        }
        return result;
    }
}
