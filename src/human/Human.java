package human;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private String name;
    private int id;
    private int birthyear;
    private Human mother;
    private Human father;
    private List<Human> children;
    private String gender;

    public Human(String name, String gender, int birthyear) {
        this.name = name;
        this.birthyear = birthyear;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public void addchildren(Human ch) {
        children.add(ch);
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\n");
        str.append(this.id + ": ");
        str.append(this.name + ": ");
        str.append(this.birthyear + ": ");
        if (this.mother != null) {
            str.append("-> мать " + this.mother.getName());
        }
        if (this.father != null)
            str.append("-> отец " + this.father.getName());
        if (this.children.size() != 0) {
            for (Human item : this.children) {
                if (item.getGender().equals("ж"))
                    str.append("-> дочь ");
                if (item.getGender().equals("м"))
                    str.append("-> сын ");
                str.append(item.getName());
            }
        }
        return str.toString();
    }

    @Override
    public int compareTo(Human h) {
        return this.name.compareTo(h.getName());
    }
}
