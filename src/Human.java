import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String startDate;
    private String endDate;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human() {
        ArrayList<Human> list = new ArrayList<Human>();
        this.children = list;
    }

    public Human(String name, String startDate, String endDate) {
        this();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Human(String name, String startDate, String endDate, Human father, Human mother) {
        this(name, startDate, endDate);
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, String startDate, String endDate, Human father, Human mother,
            List<Human> children) {
        this(name, startDate, endDate, father, mother);
        this.children = children;
    }

    public void addChildren(Human child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Human name = " + name + ", startDate = " + startDate + " , endDate = " + endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

}
