package tree.familyTree;

import tree.essences.Human;
import tree.interfaces.AlliService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FamilyTree<E extends AlliService<E>> implements Serializable, Iterable<E> {
    private List<E> peopleList;

    public FamilyTree() {
        this.peopleList = new ArrayList<>();
    }

    public void addHuman(E human) {
        this.peopleList.add(human);
    }

    public List<E> getPeopleList() {
        return peopleList;
    }

    public Set<E> getChildren(E human) {
        return human.getChildren();
    }

    public Set<E> getParents(E human) {
        return human.getParents();
    }

    /**
     * функция getDescendants ищет потомков для
     * указанного персонажа
     * 
     * @param Human - получает объект персонажа
     * @return - возвращает список потомков
     */
    public Set<E> getDescendants(E human) {
        Set<E> descendants = new HashSet<>();
        for (E child : human.getChildren()) {
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
    public Set<E> getAncestors(E human) {
        Set<E> ancestors = new HashSet<>();
        for (E parent : human.getParents()) {
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
    public Set<E> getRelatives(E human) {
        Set<E> relatives = new HashSet<>();
        relatives.addAll(getAncestors(human));
        relatives.addAll(getDescendants(human));
        return relatives;
    }

    public Set<E> searchByNames(String firstName, String lastName) {
        Set<E> result = new HashSet<>();
        for (E human : peopleList) {
            if (human.getFirstName().equals(firstName) && human.getLastName().equals(lastName)) {
                result.add(human);
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return peopleList.iterator();
    }
}
