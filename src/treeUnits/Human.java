package treeUnits;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Базовый класс человека
 */
public class Human extends TreeUnit {
    private String secondName;
    private String surname;

    public Human(Gender gender, String name, String secondName, String surname, LocalDate dateBirth, LocalDate dateDeath, Human father, Human mother) {
        super(gender, name, dateBirth, dateDeath, father, mother);
        this.secondName = secondName;
        this.surname = surname;
    }

    public Human(Gender gender, String name, String secondName, String surname, LocalDate dateBirth, LocalDate dateDeath) {
        this(gender, name, secondName, surname, dateBirth, dateDeath, null, null);
    }

    public Human(Gender gender, String name, String secondName, String surname, LocalDate dateBirth) {
        this(gender, name, secondName, surname, dateBirth, null, null, null);
    }

    public Human() {
        this(Gender.indefinite, "", "", "", null, null, null, null);
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInfo() {
        return String.format("%s %s %s (%s%s)",
                this.getName(),
                this.getSecondName(),
                this.getSurname(),
                this.getDateBirth(),
                this.getDateDeath() == null ? "" : String.format(" - %s", super.getDateDeath()));
    }

    public void printFullInfo() {
        System.out.printf("""
                        Пол: %s
                        Имя: %s
                        Отчество: %s
                        Фамилия: %s
                        Дата рождения: %s
                        Дата смерти: %s
                        Отец: %s
                        Мать: %s
                        Дети:
                        """,
                super.getGender(),
                super.getName(),
                this.getSecondName(),
                this.getSurname(),
                super.getDateBirth(),
                super.getDateDeath() == null ? " - " : super.getDateDeath(),
                super.getFather().getInfo(),
                super.getMother().getInfo()
        );
        if (super.getChildren() != null) {
            for (TreeUnit child : super.getChildren()) {
                System.out.println(child.getInfo());
            }
        } else {
            System.out.println("Детей нет.");
        }
    }
}
