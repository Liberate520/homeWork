package model.human;

import java.io.Serializable;
import java.time.Period;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable, Comparable<Human> {
    private int human_Id;
    private int parent_Id;
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private String first_parent;
    private String second_parent;
    private List<Human> children;

    public Human(int human_Id, int parent_Id, String name, LocalDate birthday, Gender gender, String second_parent) {
        this.human_Id = human_Id;
        this.parent_Id = parent_Id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.second_parent = second_parent;
        children = new ArrayList<>();
    }
    public Human(int human_Id, int parent_Id, String name, LocalDate birthday, Gender gender) {
        this (human_Id, parent_Id, name, birthday, gender,null);
    }

    public void setFirstParent(String first_parent) {
        this.first_parent = first_parent;
    }

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public int getParent_Id() {
        return parent_Id;
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb =new StringBuilder();
        sb.append(human_Id);
        sb.append(" Имя: ").append(name);
        if (gender == Gender.Male) sb.append(" пол: М ");
        else sb.append(" пол: Ж ");
        sb.append(" дата рождения: ").append(birthday);
        sb.append(" родители: ").append(first_parent).append(", ").append(second_parent);
        sb.append(" дети:").append(getChildren());
        return sb.toString();
    }

    public StringBuilder getChildren() {
        StringBuilder res = new StringBuilder();
        res.append(" ");
        if (!children.isEmpty()) {
            for (Human child: children) {
                res.append(child.getName());
                res.append(", ");
            }
        }
        else {
            res.append("Нет");
        }
        return res;
    }

    public int getHuman_Id() {
        return human_Id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human)) return false;
        Human human = (Human) obj;
        boolean b = Objects.equals(human.getName(), getName()) && Objects.equals(human.getBirthday(), getBirthday());
        return b;
    }

    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }

    public int getAge() {
        if (this.birthday == null) return 0;
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }
}
