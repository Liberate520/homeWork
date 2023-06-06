package tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Skills{
    private String name = "none";
    private LocalDate birthday;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Gender gender;
    public static List<Human> fullList = new ArrayList<>();

    //Консткукторы
    public Human () {
    }
    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        fullList.add(this);
    }

    public Human(String name, LocalDate birthday, Gender gender) {
        this(name, gender);
        this.birthday = birthday;
        fullList.add(this);
    }

    public Human(String name, LocalDate birthday, Gender gender, Human mother, Human father) {
        this(name, birthday, gender);
        this.birthday = birthday;
        this.mother = mother;
        this.father = father;
        fullList.add(this);
    }

    //Поведение сущности
    public void setFather(Human father) {
        this.father = father;
        father.children = new ArrayList<>();
        father.children.add(this);
    }

    public void setMother(Human mother) {
        this.mother = mother;
        mother.children.add(this);
    }

    public void setBirthday (LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setChild(Human child) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(child);
        if (this.gender.equals(Gender.Male)) {
            child.father = this;
        }
        else child.mother = this;
    }

    // Методы
    public List<Human> getParents() {
        List<Human> parentsList = new ArrayList<>();
        parentsList.add(mother);
        parentsList.add(father);
        return parentsList;
    }

    public List<Human> getChildren() {
        return this.children;
    }

    public List<Human> getGrandfathersList () {
        List<Human> grandfathersList = new ArrayList<>();
        grandfathersList.add(this.father.father);
        grandfathersList.add(this.mother.father);
        return grandfathersList;
    }

    public List<Human> getGrandmothersList () {
        List<Human> grandmothersList = new ArrayList<>();
        grandmothersList.add(this.father.mother);
        grandmothersList.add(this.mother.mother);
        return grandmothersList;
    }

    public Human getFather() {
        return this.father;
    };

    public Human getMother() {
        return this.mother;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public List<Human> GetGrandsonsAndGrandDaughters () {
        List<Human> grandsonsAndGrandDaughtersList = new ArrayList<>();
        for (Human human: this.children) {
            grandsonsAndGrandDaughtersList.addAll(human.children);
        }
        return grandsonsAndGrandDaughtersList;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Birthday date: " + birthday + '\n';
    }

    public String  PrintList (List<Human> children) {
        int i = 1;
        String childrenList = "";
        for (Human child: children) {
            childrenList += i + ") " + child.name + "\n";
            i++;
        }
        return childrenList;
    }

    public void PrintHuman (Human human) {
        System.out.println(human);
    }

    public void Skill () {
        String skill = this.name + ": ";
        if (!this.children.isEmpty()) {
            if (this.gender.equals(Gender.Male)) {
                skill += "I have to get the money every month";
            }
            else skill += "I have to be like a princess";
        }
        else skill += "I dont have children yet!";
        System.out.println(skill);
    }
}
