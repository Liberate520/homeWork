package familytree;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends TreeEntity> implements Serializable, Iterable<T> {
    private List<T> entities;

    public FamilyTree(){
        this.entities = new ArrayList<>();
    }

    public void addEntity(TreeEntity entity) {
        entities.add((T) entity);
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

    public List<T> getEntitiesByName(String name) {
        List<T> result = new ArrayList<>();
        for (T entity : entities) {
            if (entity.getName().equalsIgnoreCase(name)) {
                result.add(entity);
            }
        }
        return result;
    }
}
