import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human extends SerialaizableFT{
    private String name;
    private LocalDate bd;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, LocalDate bd, Gender gender, Human mother, Human father) {
        children = new ArrayList<>();
        this.name = name;
        this.bd = bd;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, LocalDate bd, Gender gender){
        this(name, bd, gender, null, null);
    }


    public String getName() {
        return name;
    }

    public LocalDate getBd() {
        return bd;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        if (!mother.children.contains(this)) {
            mother.setChildren(this);
        }
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
        if (!father.children.contains(this)) {
            father.setChildren(this);
        }
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human children: children) {
            stringBuilder.append(children.name + ", ");
        }
        return stringBuilder.toString();
    }

    public void setChildren(Human human) {
        if (!this.children.contains(human)) {
            this.children.add(human);
        }
        if (this.gender == Gender.male) {
            human.setFather(this);
        } else {
            human.setMother(this);
        }
    }

    @Override
    public String toString() {
        return this.name +
                ", " + this.bd +
                " ";
    }

    public String humanInfo() {
            return this.name +
                    ", " + this.bd +
                    ", Mother: " + this.mother +
                    ", Father: " + this.father +
                    ", children: " + this.getChildren() +
                    " ";
    }
}




