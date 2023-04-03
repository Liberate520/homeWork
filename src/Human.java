import java.io.Serializable;

public class Human implements Serializable {
    private static int count = 1;
    private int id;
    private String firstName;
    private String lastname;

    String dateOfBirth;
    String dateOfDeath;
    int idMather;
    int idFather;

    /**
     * @param firstName   Имя
     * @param lastname    Фамилия
     * @param dateOfBirth дата рождения (Формат записи "ДД-ММ-ГГГГ")
     * @param idMather    ссылка на объект Human(sex female)
     * @param idFather    ссылка на объект Human(sex male)
     */
    public Human(String firstName, String lastname, String dateOfBirth, int idMather, int idFather) {
        this.id = count++;
        this.firstName = firstName;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        this.idMather = idMather;
        this.idFather = idFather;
    }

    public Human(String firstName, String lastname, String dateOfBirth) {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfDeath() {
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
}
