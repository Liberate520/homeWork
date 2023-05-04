package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, FamilyTreeItem {
    private String fullName;
    private int age;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> kids;

    public Human(String fullName, int age, Gender gender, Human mother, Human father) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.kids = new ArrayList<>();
    }

//    public Human(String fullName, int age, Gender gender) {
//        this(fullName, age, gender, null, null);
//    }

    public void setAge(int age) {
        if (age < 0) {
            age = 0;
        } else {
            this.age = age;
        }

    }

    public void setFather(Human father) {
        if (father.getGender() == Gender.male) {
            this.father = father;
        } else {
            System.out.println("Некорректный пол");
        }
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void addKid(Human kid) {
        kids.add(kid);
    }

    @Override
    public void addKid(Object human) {
        kids.add((Human) human);
    }

    public void setMother(Human mother) {
        if (mother.getGender() == Gender.female) {
            this.mother = mother;
        } else {
            System.out.println("Некорректный пол");
        }
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public int getAge() {
        return age;
    }

    public void showKids() {
        for (Human kid: kids) {
            System.out.println(kid);
        }
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {

        return String.format("%s, возраст - %d", fullName, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Human) {
            Human h = (Human) obj;
            return h.fullName == fullName && h.getAge() == getAge();
        } else return false;

    }

    public void findSiblings() {
        Human mama = this.getMother();
        Human papa = this.getFather();
        if (mama != null) {
            for (Human kid: mama.kids) {
                if (!kid.equals(this)) {
                    System.out.println(kid);
                }
            }
        } else if (papa != null) {
            for (Human kid: papa.kids) {
                if (!kid.equals(this)) {
                    System.out.println(kid);
                }
            }
        }
    }

    @Override
    public int compareTo(Human o) {
        return fullName.compareTo(o.fullName);
    }
}
