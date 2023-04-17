package HW_5;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static java.lang.String.*;

public class Human implements Serializable, Comparable<Human> {
    private int id;
    private String firstName;
    private String lastname;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private String sex;
    private Human mather;
    private Human father;
    private final List<Human> childrens;

    /**
     * @param firstName   Имя
     * @param lastname    Фамилия
     * @param dateOfBirth дата рождения (Формат записи "ГГГГ-ММ-ДД")
     * @param sex         пол(male or female)
     * @param mather      ссылка на объект мать Human(sex female)
     * @param father      ссылка на объект отец Human(sex male)
     */
    public Human(int id, String firstName, String lastname, LocalDate dateOfBirth, Sex sex, Human mather, Human father) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        this.sex = valueOf(sex);
        this.mather = mather;
        this.father = father;
        this.childrens = new ArrayList<>();

    }

    public Human(int id, String firstName, String lastname, LocalDate dateOfBirth, Sex sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.sex = valueOf(sex);
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        this.mather = null;
        this.father = null;
        this.childrens = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public int getId() {
        return id;
    }


    public Human getMather() {
        return mather;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public String getSex() {
        return sex;
    }

    private void setMather(Human mather) {
        this.mather = mather;
    }

    private void setFather(Human father) {
        this.father = father;
    }

    /**
     * Добавить ребенка в лист детей у человека
     */
    public void addChildren(Human human) {

        if (!childrens.contains(human)) {
            childrens.add(human);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public StringBuilder getHumanInfo() {
        StringBuilder sbH = new StringBuilder();
        sbH.append(this.id);
        sbH.append(",");
        sbH.append(this.firstName);
        sbH.append(",");
        sbH.append(this.lastname);
        sbH.append(",");
        sbH.append(this.dateOfBirth);
        sbH.append(",");
        if (this.dateOfDeath != null) sbH.append(this.dateOfDeath);
        else sbH.append("-1");
        sbH.append(",");
        sbH.append(this.sex);
        return sbH;
    }

    @Override
    public String toString() {
        if (dateOfDeath != null) {
            return " %s %s(id %d) \n  Дата рождения - %s' Дата сметри - %s'\n".formatted(firstName, lastname, id, dateOfBirth, dateOfDeath);
        }
        return " %s %s (id %d) \n  Дата рождения - %s \n".formatted(firstName, lastname, id, dateOfBirth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return id == human.id && Objects.equals(firstName, human.firstName) && Objects.equals(lastname, human.lastname) && Objects.equals(dateOfBirth, human.dateOfBirth) && Objects.equals(dateOfDeath, human.dateOfDeath) && sex == human.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastname, dateOfBirth, dateOfDeath, sex);
    }

    @Override
    public int compareTo(Human o) {
        return firstName.compareTo(o.firstName);


    }


}




