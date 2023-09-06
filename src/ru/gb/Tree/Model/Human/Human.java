package ru.gb.Tree.Model.Human;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ru.gb.Tree.Model.FamilyTree.TreeItem;

public class Human implements Serializable, Comparable<Human>, TreeItem<Human> {
    private Integer id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> childrenList;
    private Human spouse;

    public Human(Integer id, String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        childrenList = new ArrayList<>();
    }

    public Human(Integer id, String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(id, name, gender, birthDate, null, mother, father);
    }

    public Human(Integer id, String name, Gender gender, LocalDate birthDate, Human mother) {
        this(id, name, gender, birthDate, null, mother, null);
    }

    public Human(Integer id, String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(id, name, gender, birthDate, deathDate, null, null);
    }

    public Human(Integer id, String name, Gender gender, LocalDate birthDate) {
        this(id, name, gender, birthDate, null, null, null);
    }

    public void addToChildren(Human child) {
        if (!childrenList.contains(child)) {
            childrenList.add(child);
        }
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!childrenList.isEmpty()) {
            res.append(childrenList.get(0).getName());
            for (int i = 1; i < childrenList.size(); i++) {
                res.append(", ");
                res.append(childrenList.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public String getSpouseInfo() {
        String res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getName() {
        return name;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getId() {
        return id;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        int age = 0;
        if (deathDate == null) {
            age = today.getYear() - birthDate.getYear();
            return age;
        } else age = deathDate.getYear() - birthDate.getYear();

        return age;
    }

    public String getInfo() {
        StringBuilder stringBuilderHuman = new StringBuilder();
        stringBuilderHuman.append("id: " + id);
        stringBuilderHuman.append(", имя: " + name);
        stringBuilderHuman.append(", пол: " + getGender());
        if (deathDate != null) {
            stringBuilderHuman.append(", годы жизни: " + birthDate + " - " + deathDate);
            stringBuilderHuman.append(", умер в: " + getAge());
        } else {
            stringBuilderHuman.append(", родился: " + birthDate);
            stringBuilderHuman.append(", возраст: " + getAge());
        }
        stringBuilderHuman.append(", " + getSpouseInfo());
        stringBuilderHuman.append(", " + getMotherInfo());
        stringBuilderHuman.append(", " + getFatherInfo());
        stringBuilderHuman.append(", " + getChildrenInfo());
        return stringBuilderHuman.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

}
