package familytree.model;

import java.io.Serializable;
import java.util.*;

public class FamilyModelTree<T extends TreeEntity> implements Serializable, Iterable<T> {
    private List<T> entities;

    public FamilyModelTree() {
        entities = new ArrayList<>();
    }

    public void addEntity(T entity) {
        entities.add(entity);
    }

    public List<T> getEntities() {
        return entities;
    }

    @Override
    public Iterator<T> iterator() {
        return entities.iterator();
    }

    public void sortByName() {
        entities.sort(Comparator.comparing(TreeEntity::getName));
    }

    public void sortByDateOfBirth() {
        entities.sort(Comparator.comparing(TreeEntity::getDOB));
    }

    public void printFamilyTree(Person person, int level) {
        String indent = "    ".repeat(level);
        System.out.println(indent + person);
        for (Person child : person.getChildren()) {
            printFamilyTree(child, level + 1);
        }
    }

    public List<TreeEntity> getEntitiesByName(String name) {
        List<TreeEntity> result = new ArrayList<>();
        for (TreeEntity entity : entities) {
            if (entity.getName().equalsIgnoreCase(name)) {
                result.add(entity);
            }
        }
        return result;
    }
}
