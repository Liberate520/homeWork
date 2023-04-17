package Package;

import java.time.LocalDate;

public class Person {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate deathDate;

    public String getName() {
        return name;
    }
   
    public String getSurname() {
        return surname;
    }
   
    public LocalDate getBirthDate() {
        return birthDate;
    }
   
    public LocalDate getDeathDate() {
        return deathDate;
    }
   
    public Person(String name, String surname, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public Person(String name, String surname, LocalDate birthDate) {
        this(name, surname, birthDate, null);
    }

    @Override
    public String toString() {
        if (name == null) {
            return "Вы не указали имя!";
        } else if (surname == null) {
            return name + ", дата рождения: " + birthDate + ", дата смерти: " + deathDate;
        } else if ((surname == null) && (deathDate == null)) {
            return name + ", дата рождения: " + birthDate;
        } else if (deathDate == null) {
            return surname + " " + name + ", дата рождения: " + birthDate;
        }
        else return surname + " " + name + ", дата рождения: " + birthDate + ", дата смерти: " + deathDate;
    }
}