package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.comparator.TreeNode;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeNode<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private Human spouse;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate, null, father, mother);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public Human getSpouse() {
        return spouse;
    }

    @Override
    public void setSpouse(Object o) {

    }

    @Override
    public void addParents(Human parent) {

    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public String getName() {
        return name;
    }

    @Override
    public void addToChild(Human child) {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ");
        stringBuilder.append(id);
        stringBuilder.append(", name: ");
        stringBuilder.append(name);
        stringBuilder.append(", gender: ");
        stringBuilder.append(getGender());
        stringBuilder.append(", age: ");
        stringBuilder.append(getAge());
        stringBuilder.append(", ");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getFatherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getChildrenInfo());

        return stringBuilder.toString();
    }

    public String getFatherInfo() {
        String res = "father: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "null";
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "mother: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "null";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("children: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("null");
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
        return human.getId() == getId();
    }
}