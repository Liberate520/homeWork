package model.tree.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private String patronymic;
    private String surname;
    private int dateBirth;
    private int dateDeath;

    private Human father;
    private Human mother;
    private List<Human> children = new ArrayList<>();

    public Human() {
    }

    /**
     * 
     * @param name       // Input null if unknown
     * @param patronymic // Input null if unknown
     * @param surname    // Input null if unknown
     * @param dateBirth  // Input 0 if unknown
     * @param dateDeath  // Input 0 if unknown
     * @param father     // Input null if unknown
     * @param mother     // Input null if unknown
     */

    public Human(String name, String patronymic, String surname,
            int dateBirth, int dateDeath, Human father, Human mother) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.father = father;
        this.mother = mother;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (name != null)
            sb.append(name);
        if (patronymic != null)
            sb.append(" " + patronymic);
        if (surname != null)
            sb.append(" " + surname);
        if (dateBirth != 0)
            sb.append(" (" + dateBirth);
        else
            sb.append(" ( ??? ");
        if (dateDeath != 0)
            sb.append(" - " + dateDeath + ")");
        else
            sb.append(" - ??? )");

        return sb.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setDateBirth(int dateBirth) {
        this.dateBirth = dateBirth;
    }

    public int getDateBirth() {
        return dateBirth;
    }

    public void setDateDeath(int dateDeath) {
        this.dateDeath = dateDeath;
    }

    public int getDateDeath() {
        return dateDeath;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human f) {
        father = f;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human m) {
        mother = m;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChildren(Human child) {
        children.add(child);
    }
}
