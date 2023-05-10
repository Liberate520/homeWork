package human;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Human implements Serializable {

    private String name;
    // private Gender gender;
    private Human father;
    private Human mother;
    private String birthDate;
    private List<Human> children;

    public Human(String name, Human father, Human mother, String birthDate) {

        this.name = name;
        // this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.birthDate = birthDate;
        children = new ArrayList<>();
    }

    public Human(String name, String birhDate) {
        this(name, null, null, birhDate);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("имя:  ");
        sb.append(name);
        sb.append(",  ");
        sb.append(getMotherInfo());
        sb.append(",  ");
        sb.append(getFatherInfo());
        sb.append(",  ");
        sb.append(getChidrenInfo());
        sb.append(",  ");
        sb.append("Год рождения:  ");
        sb.append(getBirthDate());
        return sb.toString();

    }

    public String getMotherInfo() {
        String res = "мать: ";
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChidrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети  ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствует");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }

    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }

}
