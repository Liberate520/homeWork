package model.human;

import model.famyilyTree.TreeNode;
import model.human.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, TreeNode<Human> {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateBirth;
    private LocalDate dateDeath;
    private Human father;
    private Human mother;

    private List<Human> childrens;

    public Human(int id, String firstName, String lastName, Gender gender,
                 LocalDate dateBirth, LocalDate dateDeath,
                 Human father, Human mother) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.father = father;
        this.mother = mother;
        this.childrens = new ArrayList<>();
    }

    public Human(int id, String firstName, String lastName, Gender gender,
                 LocalDate dateBirth, Human father, Human mother) {
        this(id, firstName, lastName, gender, dateBirth, null,
                father, mother);
    }

    public Human(int id, String firstName, String lastName, Gender gender,
                 LocalDate dateBirth) {
        this(id, firstName, lastName, gender, dateBirth, null,
                null, null);
    }

    public Human(int id, String firstName, String lastName, Gender gender) {
        this(id, firstName, lastName, gender, null);
    }

    public boolean addChild(Human child) {
        if (!childrens.contains((child))) {
            childrens.add(child);
            return true;
        }
        return false;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(firstName);
        sb.append(" Фамилия: ");
        sb.append(lastName);
        sb.append(" , ");
        sb.append(getFatherInfo());
        sb.append(" , ");
        sb.append(getMotherInfo());
        sb.append(" , ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public int getId() { return id; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public Gender getGender() { return gender; }

    public LocalDate getDateBirth() { return dateBirth; }
    public LocalDate getDateDeath() {
        return dateDeath;
    }

    public Human getFather() { return father; }

    public Human getMother() { return mother; }

    public List<Human> getChildren() { return childrens; }

    public void setDateBirth(LocalDate dateBirth) { this.dateBirth = dateBirth; }

    public void setDateDeath(LocalDate dateDeath) { this.dateDeath = dateDeath; }

    public void setFather(Human father) { this.father = father; }

    public void setMother(Human mother) { this.mother = mother; }

    public String getFatherInfo() {
        String res = "Отец: ";
        if (father != null) {
            res += father.getFirstName() + " " + father.getLastName();
        } else {
            res += "неизветстен";
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "Мать: ";
        if (mother != null) {
            res += mother.getFirstName() + " " + mother.getLastName();
        } else {
            res += "неизветстна";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if (childrens.size() != 0) {
            res.append(childrens.get(0).getFirstName());
            for (int i = 1; i < childrens.size(); i++) {
                res.append(", " + childrens.get(i).getFirstName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == this.getId();
    }

    public int compareTo(Human h) {
        return firstName.compareTo(h.firstName);
    }
}

