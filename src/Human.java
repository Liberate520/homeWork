package OOPjava1.src;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String family;
    private String burndate;
    private List<Human> parents;
    private List<Human> children;

    public Human(String family, String name, String burndate) {
        this.name = name;
        this.family = family;
        this.burndate = burndate;
        this.parents = new ArrayList<Human>();
        this.children = new ArrayList<Human>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setBurndate(String burndate) {
        this.burndate = burndate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(Human person) {
        this.parents.add(person);
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(Human person) {
        this.children.add(person);
    }

    @Override
    public String toString() {
        return "Фамилия: " + this.family + "," + " Имя: " + this.name + "," + " Дата рождения: " + this.burndate;
    }
}
