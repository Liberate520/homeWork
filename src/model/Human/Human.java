package model.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable{
    private final String name;
    private final String surname;
    private final LocalDate birthday;
    private Human mother;
    private Human father;
    public Human(String name, String surname, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }
    public Human(String name, String surname, LocalDate birthday, Human mother,Human father) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.mother = mother;
        this.father = father;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " +  birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;

        if (getName() != null ? !getName().equals(human.getName()) : human.getName() != null) return false;
        return getSurname() != null ? getSurname().equals(human.getSurname()) : human.getSurname() == null;
    }
}



