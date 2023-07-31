package model.person;

import model.familyTree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Семейные связи полностью находятся в model.familyTree.
 */
public class Person implements Serializable, Comparable<Person>, TreeNode<Person> {
    private String name, surname, maidenName, patronymic;
    private Gender sex;
    private LocalDate dateBirth, dateDeath;

    public Person(String name, String surname, String patronymic, Gender sex, LocalDate dateBirth,
                  String maidenName, LocalDate dateDeath) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.sex = sex;
        this.dateBirth = dateBirth;
        this.maidenName = maidenName;
        this.dateDeath = dateDeath;
    }

    public Person(String name, String surname, String patronymic, Gender sex, LocalDate dateBirth,
                  String maidenName) {
        this(name, surname, patronymic, sex, dateBirth, maidenName, null);
    }

    public Person(String name, String surname, String patronymic, Gender sex, LocalDate dateBirth,
                  LocalDate dateDeath) {
        this(name, surname, patronymic, sex, dateBirth, null, dateDeath);
    }

    public Person(String name, String surname, String patronymic, Gender sex, LocalDate dateBirth) {
        this(name, surname, patronymic, sex, dateBirth, null, null);
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String briefName() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        if (dateDeath == null && sex.equals(Gender.MALE))
            return String.format("%s %s %s, родился %s.", name, patronymic, surname, dateBirth);
        else if (dateDeath == null && sex.equals(Gender.FEMALE))
            return String.format("%s %s %s, родилась %s.", name, patronymic, surname, dateBirth);
        else if (sex.equals(Gender.MALE))
            return String.format("%s %s %s, родился %s, умер %s.", name, patronymic, surname,
                    dateBirth, dateDeath);
        else
            return String.format("%s %s %s, родилась %s, умерла %s.", name, patronymic, surname,
                    dateBirth, dateDeath);
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
