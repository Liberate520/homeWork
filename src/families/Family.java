package families;

import essence.Essence;
import essence.Human;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Family<T extends Essence<T>> implements Tree<T>, Serializable, Iterable<T> {
    List<T> family = new ArrayList<>();
    @Override
    public void addMember(T t) {
        if(!family.contains(t))family.add(t);
        else System.out.println("Такой уже есть");
    }

    @Override
    public List<T> getPeopleList() {
        return family;
    }

    @Override
    public List<T> getChildren(T t) {
        return new ArrayList<>(t.getChildren());
    }

    @Override
    public List<T> getParents(T t) {
        return new ArrayList<>(t.getParents());
    }

    @Override
    public List<T> getDescendants(T t) {
        List<T> descendants = new ArrayList<>();
        for (T child : t.getChildren()) {
            descendants.add(child);
            descendants.addAll(getDescendants(child));
        }
        return descendants;
    }

    @Override
    public List<T> getAncestors(T t) {
        return new ArrayList<>(t.getParents());
    }

    @Override
    public List<T> getRelatives(T t) {
        List<T> relatives = new ArrayList<>();
        relatives.addAll(getAncestors(t));
        relatives.addAll(getDescendants(t));
        return relatives;
    }

    @Override
    public T searchByName(String name) {
        for (T t : family) {
            if (t.toString().contains(name)) {
                return t;
            }
        }
        return null;
    }


    public void setMarriage(Human human, Human human2) {
        human.setIn_marriage_with(human2);
        human2.setIn_marriage_with(human);
    }

    @Override
    public void setChildren(T parent, T child) {
        if(!parent.getChildren().contains(child)){
            this.addMember(child);
            parent.setChildren(child);
            (parent.getIn_marriage_with()).setChildren(child);
            child.setParents(parent);
            child.setParents(parent.getIn_marriage_with());}
        else System.out.println("Такой уже есть");
    }

    @Override
    public void save(Writable<T> writable) throws IOException {
        writable.save(this);
    }

    @Override
    public void getInfo() {
        for (T t : family) {
            System.out.println(t);
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<T>(family);
    }
}
