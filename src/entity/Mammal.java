package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Mammal implements Serializable, Comparable<Mammal>  {
    protected String type = "mammal";
    private int id;
    private String name;
    private String gender;
    private Mammal father;
    private Mammal mother;
    private List<Mammal> children;

    public Mammal(int id, String name, String gender, Mammal father, Mammal mother) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
        addChild(father);
        addChild(mother);
    }

    public Mammal(int id, String name, String gender) {
        this(id, name, gender, null, null);
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Mammal getFather() {
        return father;
    }

    public Mammal getMother() {
        return mother;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public List<Mammal> getChildren() {
        return children;
    }

    public void addChild(Mammal parent) {
        if (parent != null)
            parent.children.add(this);
    }

    @Override
    public String toString() {
        String s = "id: " + String.format("%d", id) + "; type: " + type + "; name: " + name + "; gender: " + gender;

        if (father != null)
            s += "; father: " + father.name;

        if (mother != null)
            s += "; mother: " + mother.name;

        if (children.size() > 0) {
            s += "; ";
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i).gender.equals("male"))
                    s += "son: " + children.get(i).name;
                else
                    s += "daughter: " + children.get(i).name;
                s += (i < children.size() - 1 ? "; " : "");
            }
        }

        List<Mammal>  brothersSistersList = getBrothersSisters();
        if (brothersSistersList.size() > 0) {
            s += "; ";
            for (int i = 0; i < brothersSistersList.size(); i++) {
                if (brothersSistersList.get(i).gender.equals("male"))
                    s += "brother: " + brothersSistersList.get(i).name;
                else
                    s += "sister: " + brothersSistersList.get(i).name;
                s += (i < brothersSistersList.size() - 1 ? "; " : "");
            }
        }
        return s;
    }

    public List<Mammal> getBrothersSisters() {
        List<Mammal> brothersSistersList;

        if (father != null && mother == null)
            brothersSistersList = new ArrayList(father.children);
        else if (father == null && mother != null)
            brothersSistersList = new ArrayList(mother.children);
        else if (father != null && mother != null) {
            brothersSistersList = new ArrayList(father.children);
            List<Mammal> motherChildren = new ArrayList(mother.children);
            brothersSistersList.removeAll(motherChildren);
            brothersSistersList.addAll(motherChildren);
        }
        else
            brothersSistersList = new ArrayList();

        brothersSistersList.remove(this);
        return brothersSistersList;
    }

    @Override
    public int compareTo(Mammal o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
}
