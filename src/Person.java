

public class Person {
    private String name, surname, maidenName, patrynomic;
    private Gender sex;
    private int yearBirth, yearDeath;

    public Person(String name, String surname, String patrynomic, Gender sex, int yearBirth,
                  String maidenName, int yearDeath) {
        this(name, surname, patrynomic, sex, yearBirth);
        this.maidenName = maidenName;
        this.yearDeath = yearDeath;
    }

    public Person(String name, String surname, String patrynomic, Gender sex, int yearBirth,
                  String maidenName) {
        this(name, surname, patrynomic, sex, yearBirth);
        this.maidenName = maidenName;
    }

    public Person(String name, String surname, String patrynomic, Gender sex, int yearBirth,
                  int yearDeath) {
        this(name, surname, patrynomic, sex, yearBirth);
        this.yearDeath = yearDeath;
    }

    public Person(String name, String surname, String patrynomic, Gender sex, int yearBirth) {
        this.name = name;
        this.surname = surname;
        this.patrynomic = patrynomic;
        this.sex = sex;
        this.yearBirth = yearBirth;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public String getPatrynomic() {
        return patrynomic;
    }

    public Gender getSex() {
        return sex;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public int getYearDeath() {
        return yearDeath;
    }

    public String briefName() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        if (yearDeath == 0 && sex.equals(Gender.MALE))
            return String.format("%s %s %s, родился в %d году.", name, patrynomic, surname, yearBirth);
        else if (yearDeath == 0 && sex.equals(Gender.FEMALE))
            return String.format("%s %s %s, родилась в %d году.", name, patrynomic, surname, yearBirth);
        else if (sex.equals(Gender.MALE))
            return String.format("%s %s %s, родился в %d году, умер в %d году.", name, patrynomic, surname,
                    yearBirth, yearDeath);
        else
            return String.format("%s %s %s, родилась в %d году, умерла в %d году.", name, patrynomic, surname,
                    yearBirth, yearDeath);
    }
}
