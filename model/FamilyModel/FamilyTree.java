package model.FamilyModel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import java.io.Serializable;
import java.util.*;

import model.HumanModel.*;

public class FamilyTree<T extends HumanInterface<T>> implements Serializable, Iterable<T> {

    private static final long serialVersionUID = 1L;

    private long id;

    private List<T> entityList;

    public List<T> getHumanList() {
        return entityList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> entityList) {
        this.entityList = entityList;
    }

    public void add(T entity) {
        if (entity != null) {
            if (!entityList.contains(entity)) {
                entity.setId(this.id++);
                this.entityList.add(entity);
            }
        }
    }

    public T findFather(T entity) {
        for (T h : this.entityList) {
            if (h == entity.getFather()) {
                return h;
            }
        }
        return null;
    }

    public T findMather(T entity) {
        for (T h : this.entityList) {
            if (h == entity.getMather()) {
                return h;
            }
        }
        return null;
    }

    public List<T> findChildren(T entity) {
        List<T> lst = new ArrayList<>();
        for (T h : this.entityList) {
            if (h.getMather() == entity || h.getFather() == entity) {
                lst.add(h);
            }
        }
        return lst;
    }

    // Переопредиляем
    @Override
    public Iterator<T> iterator() {
        return this.entityList.iterator();
    }

    public void sortByFirstName() {
        Collections.sort(entityList, Comparator.comparing(T::getFirstName));
    }

    public void sortByBirthDate() {
        Collections.sort(entityList, Comparator.comparing(T::getBirthDate));
    }

    public T getID(int id) {
        for (T h : this.entityList) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }
}
