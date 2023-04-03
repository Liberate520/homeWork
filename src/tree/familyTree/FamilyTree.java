package tree.familyTree;

import tree.human.Human;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    public Set<Human> getChildren(Human human) {
        return human.getChildren();
    }

    public Set<Human> getParents(Human human) {
        return human.getParents();
    }

    /**
     * функция getDescendants ищет потомков для
     * указанного персонажа
     * 
     * @param Human - получает объект персонажа
     * @return - возвращает список потомков
     */
    public Set<Human> getDescendants(Human Human) {
        Set<Human> descendants = new TreeSet<>();
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
    public Set<Human> getAncestors(Human Human) {
        Set<Human> ancestors = new TreeSet<>();
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
    public Set<Human> getRelatives(Human Human) {
        Set<Human> relatives = new TreeSet<>();
        relatives.addAll(getAncestors(Human));
        relatives.addAll(getDescendants(Human));
        return relatives;
    }

    public Set<Human> searchByName(String name) {
        Set<Human> result = new TreeSet<>();
        for (Human Human : peopleList) {
            result.add(Human);
        }
        return result;
    }
}
