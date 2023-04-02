

public class _Human {
    private String name;
    private String surname;
    private String manOrWoman;
    private String birthday;
    private String dateOfDeath;

    public _Human(String name, String surname, String manOrWoman, String birthday){
        this(name, surname, manOrWoman, birthday, "Жив");
//        this.dateOfDeath = "Жив";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getManOrWoman() {
        return manOrWoman;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public _Human(String name, String surname, String manOrWoman, String birthday, String dateOfDeath) {
        this.name = name;
        this.surname = surname;
        this.manOrWoman = manOrWoman;
        this.birthday = birthday;
        this.dateOfDeath = dateOfDeath;
    }



    @Override
    public String toString() {
        return String.format("Имя: %s \nФамилия: %s \nПол: %s \nДата рождения: %s \nДата смерти: %s \n", name, surname, manOrWoman, birthday, dateOfDeath);
    }
}
