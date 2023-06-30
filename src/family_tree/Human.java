package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Human implements Serializable {
    private  String surname;
    private String first_name;
    private String patronymic;
    private LocalDate day_birth;
    private LocalDate day_death;
    private Gender gender;
    private Human mother, father;
    private List<Human> children;

    public Human(Gender gender) {
        this.gender = gender;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDay_birth(LocalDate day_birth) {
        this.day_birth = day_birth;
    }

    public void setDay_death(LocalDate day_death) {
        this.day_death = day_death;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDay_birth() {
        return day_birth;
    }

    public LocalDate getDay_death() {
        return day_death;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }


    @Override
    public String toString() {
        return "\nФамилия: " + surname + '\n' +
                "Имя: " + first_name + '\n' +
                "Отчество: " + patronymic + '\n' +
                "Дата рождения: " + day_birth + '\n' +
                "Дата смерти: " + day_death + '\n' +
                "Пол: " + gender + '\n' +
                "Мать: " + mother + '\n' +
                "Отец: " + father + '\n' +
                "Дети: " + children + '\n' +
                '}';
    }


}


