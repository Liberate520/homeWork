package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class FamilyTree<T extends FamalyTreeItem> implements Serializable, Iterable<T> {
    private List<T> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public void addHuman(T human) {
        humans.add(human);
        if (human.getMother() != null) {
            human.getMother().addChild(human);
        }
        if (human.getFather() != null) {
            human.getFather().addChild(human);
        }
    }

    public List<T> getHumans() {
        return humans;
    }

    public List<T> getParents(T human) {
        List<T> parents = new ArrayList<>();
        T mother = (T) human.getMother();
        if (mother != null) {
            parents.add(mother);
        }
        T father = (T) human.getFather();
        if (father != null) {
            parents.add(father);
        }
        return parents;
    }

    public List<T> getSiblings(T human) {
        List<T> siblings = new ArrayList<>();
        List<T> parents = getParents(human);
        for (T parent : parents) {
            List<T> parentSiblings = getChildren(parent);
            parentSiblings.remove(human);
            siblings.addAll(parentSiblings);
        }
        return siblings;
    }

    public List<T> getChildren(T human) {
        return (List<T>) human.getChildren();
    }

    public List<T> getDescendants(T human) {
        List<T> descendants = new ArrayList<>();
        List<T> children = getChildren(human);
        descendants.addAll(children);
        for (T child : children) {
            descendants.addAll(getDescendants(child));
        }
        return descendants;
    }

    public List<T> getAncestors(T human) {
        List<T> ancestors = new ArrayList<>();
        List<T> parents = getParents(human);
        ancestors.addAll(parents);
        for (T parent : parents) {
            ancestors.addAll(getAncestors(parent));
        }
        return ancestors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        FamilyTree<T> that = (FamilyTree<T>) o;
        return Objects.equals(humans, that.humans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(humans);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humans);
        sb.append(" объектов: \n");
        for (T human : humans){
            sb.append(human.toString());    
            sb.append("\n");       
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator(humans);
    }
    
}
