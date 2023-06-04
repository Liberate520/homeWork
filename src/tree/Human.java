package tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    //    private static int global_id;
    //    private int id;
    private final String surName;
    private final String name;
    private final String secondName;
    private final Gender gender;
    private LocalDate birthday;
    private LocalDate dieDate;
    private Human father;
    private Human mother;
    private final List<Human> children;


    public Human(String surName, String name, String secondName, Gender gender, Human father, Human mother) {
//        this.id = id;
        this.surName = surName;
        this.name = name;
        this.secondName = secondName;
        this.gender = gender;
        this.birthday = birthday;
        this.dieDate = dieDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();

    }

    public Human(String surName, String name, String secondName, Gender gender, LocalDate birthday) {
        this(surName, name, secondName, gender, birthday, null, null);
    }


    public Human(String surName, String name, String secondName, Gender gender, LocalDate birthday, Human father, Human mother) {
        this(surName, name, secondName, gender, father, mother);
    }

    public String getSurName() {
        return surName;
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getDieDate() {
        return dieDate;
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

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setDieDate(LocalDate dieDate) {
        this.dieDate = dieDate;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Gender getGender() {
        return gender;
    }

    public String getInfoHuman() {
        StringBuilder sb = new StringBuilder();
        sb.append("Фамилия: ");
        sb.append(surName);
        sb.append(", ");
        sb.append("Имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append("Отчество: ");
        sb.append(secondName);
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();

    }

    public String getInfoName() {
        return surName + name + secondName;

    }

    public String getFatherInfo() {
        String res = "Отец: ";
        if (father != null) {
            res += father.getSurName() + " " + father.getName() + " " + father.getSecondName();
        } else {
            res += "неизвестен";
        }
        return res;

    }

    public String getMotherInfo() {
        String res = "Мать: ";
        if (mother != null) {
            res += mother.getSurName() + " " + mother.getName() + " " + mother.getSecondName();
        } else {
            res += "неизвестна";
        }
        return res;

    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети : ");
        if (children.size() != 0) {
            res.append(children.get(0).getSurName());
            res.append(" ");
            res.append(children.get(0).getName());
            res.append(" ");
            res.append(children.get(0).getSecondName());
            for (int i = 1; i < children.size(); i++) {
                res.append("\n");
                res.append(children.get(i).getSurName());
                res.append(" ");
                res.append(children.get(i).getName());
                res.append(" ");
                res.append(children.get(i).getSecondName());

            }
        } else {
            res.append(" отсутствуют ");
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
}

