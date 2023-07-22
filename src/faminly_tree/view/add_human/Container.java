package faminly_tree.view.add_human;

import java.time.LocalDate;

public class Container implements ContentionFields {
    private String name, surname, patronymic, sex;
    private LocalDate birth, death;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public LocalDate getBirth() {
        return birth;
    }
    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
    public LocalDate getDeath() {
        return death;
    }
    public void setDeath(LocalDate death) {
        this.death = death;
    }
}
