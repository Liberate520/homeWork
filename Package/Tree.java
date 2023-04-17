package Package;

import java.util.List;

public class Tree {
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public List<Person> getChildren() {
        return children;
    }

    public Tree(Person father, Person mother, List<Person> children) {
        this.father = father;
        this.mother = mother;
        this.children = children;
    }
    public Tree(List<Person> children) {
        this(null, null, children);
    }
    public Tree() {
        this(null, null, null);
    }

    public void addMember(Person person) {
        children.add(person);
    }

    public void family(Person person) {
        getFather();
        getMother();
        getChildren();
    }


    @Override
    public String toString() {
        if ((father == null) && (mother == null)) {
            return String.format("Дети: %s", children);
        } else if (children == null) {
            return String.format("Отец: %s\nМать: %s", father.toString(), mother.toString());
        }
        else return String.format("Отец: %s\nМать: %s\nДети: %s", father.toString(), mother.toString(), children);
    }
}
