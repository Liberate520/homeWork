import java.util.HashSet;

public class Parent extends Human {
    private HashSet<Children> childrens;

    Parent(String firstName, String secondName, int day, int month, int year, String sex, HashSet<Children> childrens) {
        super(firstName, secondName, day, month, year, sex);
        this.childrens = childrens;
    }

    Parent(String firstName, String secondName, int day, int month, int year, String sex) {
        this(firstName, secondName, day, month, year, sex, new HashSet<Children>());
    }

    Parent(Human person) {
        this(person.getFirstName(), person.getLastName(), person.getDay(), person.getMonth(),
            person.getYear(), person.getSex());
    }

    public void addChildrens(Children children) {
        this.childrens.add(children);
    }

    public HashSet<Children> getChildrens() {
        return childrens;
    }

    public boolean equals(Object o) {
        Parent that = (Parent) o;
        that.childrens.addAll(this.childrens);
        this.childrens.addAll(that.childrens);
        return super.equals(o);
    }

    
    
    
}