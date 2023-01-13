import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Members<E extends Members> implements Serializable, Comparable<E> {
    protected String name;
    protected int yearBorn;
    protected int yearDead;
    protected E father;
    protected E mother;
    protected ArrayList<E> children;
    protected String sex;

    public Members(String name, int yearBorn, int yearDead, E father, E mother,
            ArrayList<E> children, String sex) {
        this.name = name;
        this.yearBorn = yearBorn;
        this.yearDead = yearDead;
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.sex = sex;
    }

    @Override
    public abstract String toString();

    public E getFather() {
        return father;
    }

    public E getMother() {
        return mother;
    }

    public void addChild(E ch) {
        children.add(ch);

    }

    public List<E> getChild() {
        return children;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(E o) {
        return Integer.compare(this.yearBorn, o.yearBorn);
    }

}
