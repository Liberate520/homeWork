package models.members;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/** human */
public class Human implements Serializable, FamilyMember {
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private FamilyMember mother;
    private FamilyMember father;
    private final List<FamilyMember> children;

    /** return human name */
    public String getName() {
        return this.name;
    }

    /** return human year birth */
    public LocalDate getBirthday() {
        return this.birthday;
    }

    /** return human gender */
    public Gender getGender() {
        return gender;
    }

    /** количество детей */
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

    /** checked contains child in children list */
    public Boolean containsChild(FamilyMember child) {
        for (FamilyMember member : children) {
            if (member.equals(child)) {
                return true;
            }
        }
        return false;
    }

    /** returned mother */
    public FamilyMember getMother() {
        return mother;
    }

    /** returned father */
    public FamilyMember getFather() {
        return father;
    }

    /** added child in children list */
    public void addChild(FamilyMember child) {

        if (!containsChild(child)) {
            children.add(child);
        }
    }

    /** representation */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" ");
        builder.append("(").append(formatter.format(birthday)).append(")\n");
        builder.append("[").append(gender).append("] ");
        builder.append(children.size()).append(" children,\n");
        if (father != null) {
            builder.append("father: ").append(father.getName()).append("\n");
        }
        if (mother != null) {
            builder.append("mother: ").append(mother.getName()).append("\n");
        }
        return builder.toString();
    }

    public String GetShortInfo() {
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
    public void setFather(FamilyMember father) {
        this.father = father;
    }

    @Override
    public void setMother(FamilyMember mother) {
        this.mother = mother;
    }

    @Override
    public void removeChild(FamilyMember child) {
        if(containsChild(child)){ 
            children.remove(child);
        }
    }
}
