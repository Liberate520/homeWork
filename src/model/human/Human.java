package model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, TreeMember {
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private TreeMember mother;
    private TreeMember father;
    private final List<TreeMember> children;

    public String getName() {
        return this.name;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public int getChildrenAmount() {
        return children.size();
    }

    public Human(String name, LocalDate birthday, Gender gender, Human father, Human mother) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        children = new ArrayList<>();
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, LocalDate birthday, Gender gender) {
        this(name, birthday, gender, null, null);
    }

    public Boolean containsChild(TreeMember child) {
        for (TreeMember member : children) {
            if (member.equals(child)) {
                return true;
            }
        }
        return false;
    }

    public TreeMember getMother() {
        return mother;
    }

    public TreeMember getFather() {
        return father;
    }

    public void addChild(TreeMember child) {

        if (!containsChild(child)) {
            children.add(child);
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd mmmm yyyy");
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" ");
        builder.append("(").append(formatter.format(birthday)).append(")\n");
        builder.append("[").append(gender).append("] ");
        builder.append(children.size()).append(" дети,\n");
        if (father != null) {
            builder.append("отец: ").append(father.getName()).append("\n");
        }
        if (mother != null) {
            builder.append("мать: ").append(mother.getName()).append("\n");
        }
        return builder.toString();
    }

    public String getShortInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        return name + " " +
                "(" + formatter.format(birthday) + ")" +
                "[" + gender + "] ";
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public void setFather(TreeMember father) {
        this.father = father;
    }

    @Override
    public void setMother(TreeMember mother) {
        this.mother = mother;
    }

    @Override
    public void removeChild(TreeMember child) {
        if(containsChild(child)){
            children.remove(child);
        }
    }
}
