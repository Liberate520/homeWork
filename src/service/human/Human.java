package service.human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private String name;
    private int id;
    private int yearBirth;
    private int yearDeath;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children = new ArrayList<>();

    public Human() {
    }

    public Human(String name, Human father, Human mother) {
        this();
        setName(name);
        this.father = father;
        this.mother = mother;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildrenList() {
        return children;
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Дети: ");
        if (children.size() != 0) {
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        } else {
            sb.append("нет");
        }
        return sb.toString();
    }

    public void addChild(Human child) {
        if (!(this.children.contains(child))) {
            this.children.add(child);
        }
    }

    public String getFatherInfo() {
        String res = "Отец :";
        if (father != null) {
            res += father.getName();
        } else {
            return res + "неизвестен";
        }
        return res;
    }

    public String getMatherInfo() {
        String res = "Мать :";
        if (mother != null) {
            res += mother.getName();
        } else {
            return res + "неизвестна";
        }
        return res;
    }

    public int getYearBirth() {
        return this.yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public int getYearDeath() {
        return this.yearDeath;
    }

    public void setYearDeath(int yearDeath) {
        this.yearDeath = yearDeath;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(" id: ");
        sb.append(getId());
        sb.append(", ");
        sb.append("Имя: ");
        sb.append(getName());
        sb.append(", ");
        sb.append(getMatherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        if (getYearBirth() != 0) {
            sb.append(", родился в: ");
            sb.append(getYearBirth() + "г");
        }
        if (getYearDeath() != 0) {
            sb.append(", умер в: ");
            sb.append(getYearDeath() + "г");
        }
        sb.append(".");
        return sb.toString();
    }

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
    public String toString() {
        return  getName();
    }

    @Override
    public int compareTo(Human o) {
        return o.getId();
    }
}
