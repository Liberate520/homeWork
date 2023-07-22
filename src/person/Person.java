package person;

import java.io.Serializable;

/**
 * Пока что ставлю даты просто в формате гггг int. Потому что не знаю всех дней рождений, и тем более смертей,
 * и не умею пока работать с LocalTime. Семейные связи полностью находятся в familyTree.FamilyTree.
 */
public class Person implements Serializable {
    private String name, surname, maidenName, patronymic;
    private Gender sex;
    private int yearBirth, yearDeath;

    public Person(String name, String surname, String patronymic, Gender sex, int yearBirth,
                  String maidenName, int yearDeath) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.sex = sex;
        this.yearBirth = yearBirth;
        this.maidenName = maidenName;
        this.yearDeath = yearDeath;
    }

    public Person(String name, String surname, String patronymic, Gender sex, int yearBirth,
                  String maidenName) {
        this(name, surname, patronymic, sex, yearBirth, maidenName, -1);
    }

    public Person(String name, String surname, String patronymic, Gender sex, int yearBirth,
                  int yearDeath) {
        this(name, surname, patronymic, sex, yearBirth, null, yearDeath);
    }

    public Person(String name, String surname, String patronymic, Gender sex, int yearBirth) {
        this(name, surname, patronymic, sex, yearBirth, null, -1);
    }

    public String briefName() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        if (yearDeath == 0 && sex.equals(Gender.MALE))
            return String.format("%s %s %s, родился в %d году.", name, patronymic, surname, yearBirth);
        else if (yearDeath == 0 && sex.equals(Gender.FEMALE))
            return String.format("%s %s %s, родилась в %d году.", name, patronymic, surname, yearBirth);
        else if (sex.equals(Gender.MALE))
            return String.format("%s %s %s, родился в %d году, умер в %d году.", name, patronymic, surname,
                    yearBirth, yearDeath);
        else
            return String.format("%s %s %s, родилась в %d году, умерла в %d году.", name, patronymic, surname,
                    yearBirth, yearDeath);
    }
}
