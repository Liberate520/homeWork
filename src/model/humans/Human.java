package model.humans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable, FamilyTreeItem {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String dateOfBirth;
    private String dateOfDeath;
    private Human mother;
    private Human father;
    private List<Human> childrenList;

    /**
     * @param firstName    - Имя
     * @param lastName     - Фамилия
     * @param gender       - Пол
     * @param dateOfBirth  - Дата рождения
     * @param dateOfDeath  - Дата смерти ( не обязательно )
     * @param mother       - Мать (не обязательно)
     * @param father       - Отец (не обязательно)
     * @param childrenList Дети ( не обязательно)
     */
    public Human(int id, String firstName, String lastName, Gender gender,
                 String dateOfBirth, String dateOfDeath, Human mother,
                 Human father, List<Human> childrenList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        this.childrenList = childrenList;
    }

    /**
     * Конструктор ,который позволят не заполнять неочевидные поля
     */
    public Human(int id, String firstName, String lastName, Gender gender, String dateOfBirth) {
        this(id, firstName, lastName, gender, dateOfBirth, null, null, null, null);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Human getMother() {
        return mother;
    }

    /**
     * При изменении  поля "мать" , у обьекта "Мать" добавляется "ребенок"
     */
    public void setMother(Human newMother) {
        this.mother = newMother;
        newMother.addChild(this);

    }

    public Human getFather() {
        return father;
    }

    /**
     * При изменении  поля "отец" , у обьекта "Отец" добавляется "ребенок"
     */
    public void setFather(Human NewFather) {
        this.mother = NewFather;
        NewFather.childrenList = new ArrayList<>();
        NewFather.childrenList.add(this);
    }

    public List<Human> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Human> childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.firstName == firstName || this.lastName == lastName || this.dateOfBirth == dateOfBirth) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth);
    }

    @Override
    public String toString() {
        String temp = "неопределенно";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id= " + id + "\n");
        stringBuilder.append("Имя= " + firstName + "\n");
        stringBuilder.append("Фамилия= " + lastName + "\n");
        stringBuilder.append("Пол= " + gender + "\n");
        stringBuilder.append("Дата рождения= " + dateOfBirth + "\n");
        if (dateOfDeath != null) stringBuilder.append("Дата смерти= " + dateOfDeath + "\n");
        else stringBuilder.append("Дата смерти= " + temp + "\n");
        if (mother != null) stringBuilder.append("Мать= " + mother.getFullName() + "\n");
        else stringBuilder.append("Мать= " + temp + "\n");
        if (father != null) stringBuilder.append("Отец= " + mother.getFullName() + "\n");
        else stringBuilder.append("Отец= " + temp + "\n");
        if (childrenList == null) stringBuilder.append("Дети= " + temp + "\n");
        else {
            stringBuilder.append("Дети: ");
            for (Human child : childrenList) {
                stringBuilder.append(child.getFullName());
            }
        }
        return stringBuilder.toString();
    }

    public String getFullName() {
        return this.getLastName() + " " + this.getFirstName();
    }

    /**
     * Выдает информацию о человеке
     */
    public String getInfo(Human human) {
        return human.toString();
    }

    public boolean addChild(Human child) {
        if (childrenList == null) {
            childrenList = new ArrayList<>();
        }
        if (!childrenList.contains(child)) {
            childrenList.add(child);
            return true;
        }
        return false;
    }
}

