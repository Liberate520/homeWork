package ru.java_oop.family_tree.family_tree;

import ru.java_oop.family_tree.human.EntityComparatorByAge;
import ru.java_oop.family_tree.human.EntityComparatorByName;
import ru.java_oop.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    private long entityId;
    private List<E> entityList;

    public FamilyTree(List<E> entityList) {
        this.entityList = entityList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<E> getEntityList() {
        return entityList;
    }

    public boolean addFamilyMember(E entity) {
        if (entity == null) {
            return false;
        }
        if (!this.entityList.contains(entity)) {
            this.entityList.add(entity);
            entity.setId(entityId++);
            this.addToParents(entity);
            this.addToChildren(entity);
            return true;
        }
        return false;
    }

    private void addToParents(E entity) {
        for (FamilyTreeItem parent : entity.getParents()) {
            parent.addChild(entity);
        }
    }

    private <T extends FamilyTreeItem> void addToChildren(T entity) {
        for (FamilyTreeItem child : entity.getChildren()) {
            child.addParent(entity);
        }
    }

    public List<E> getByName(String name) {
        List<E> result = new ArrayList<>();
        for (E e : this.entityList) {
            if (e.getName().equalsIgnoreCase(name)) {
                result.add(e);
            }
        }
        return result;
    }

    public E getById(long id) {
        for (E e : this.entityList) {
            if (e.getId() == id) {
                return e;
            }
        }

        return null;
    }

    private boolean checkId(long id) {
        if (id >= this.entityId || id < 0) {
            return false;
        }
        for (E e : this.entityList) {
            if (e.getId() == id) {
                return true;
            }
        }
        return false;

    }

    public boolean setWedding(long entityId1, long entityId2) {
        if (checkId(entityId1) && checkId(entityId2)) {
            E entity1 = getById(entityId1);
            E entity2 = getById(entityId2);
            if (entity1.getSpouse() == null && entity2.getSpouse() == null) {
                entity1.setSpouse(entity2);
                entity2.setSpouse(entity1);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean divorce(long entityId1, long entityId2) {
        if (checkId(entityId1) && checkId(entityId2)) {
            E entity1 = getById(entityId1);
            E entity2 = getById(entityId2);
            if (entity1.getSpouse() == entity2 && entity2.getSpouse() == entity1) {
                entity1.setSpouse(null);
                entity2.setSpouse(null);
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Family tree contains ").append(this.entityList.size()).append(" objects\n");
        for (E entity : this.entityList) {
            sb.append(entity).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(entityList);
    }

    public void sortByAge() {
        entityList.sort(new EntityComparatorByAge<>());
//        Collections.sort(humanList, new HumanComparatorByAge());
    }

    public void sortByName() {
        entityList.sort(new EntityComparatorByName<>());
//        Collections.sort(humanList, new HumanComparatorByName());
    }
}
