import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable, Comparable<Human> {
    private int count = 1;
    private final int id;
    private final String firstName;
    private final String lastname;
    private final LocalDate dateOfBirth;
    private final LocalDate dateOfDeath;
    private int idMather;
    private int idFather;

    /**
     * @param firstName   Имя
     * @param lastname    Фамилия
     * @param dateOfBirth дата рождения (Формат записи "ДД-ММ-ГГГГ")
     * @param idMather    ссылка на объект Human(sex female)
     * @param idFather    ссылка на объект Human(sex male)
     */
    public Human(String firstName, String lastname, LocalDate dateOfBirth, int idMather, int idFather) {
        this.id = count++;
        this.firstName = firstName;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        this.idMather = idMather;
        this.idFather = idFather;
    }

    public Human(String firstName, String lastname, LocalDate dateOfBirth) {
        this.id = count++;
        this.firstName = firstName;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
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

    public int getIdMather() {
        return idMather;
    }

    public int getIdFather() {
        return idFather;
    }

    @Override
    public String toString() {
        if (dateOfDeath != null) {
            return "%s %s дата рождения - %s' Дата смерти - %s'".formatted(firstName, lastname, dateOfBirth, dateOfDeath);
        }
        return "%s %s дата рождения - %s".formatted(firstName, lastname, dateOfBirth);
    }
    @Override
    public int compareTo(Human o) {
        return firstName.compareTo(o.firstName);
    }
}
