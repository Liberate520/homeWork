import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable, Comparable<Person> {
    private LocalDate birthDate;
    private LocalDate deathDate;
    protected String firstname;
    private String surname;
    private String patronymic;
    private Gender gender;

    public Person(Gender gender, String surename, String firstname, String patronymic, LocalDate birthDate, LocalDate deathDate) {
        this.firstname = firstname;
        this.surname = surename;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public Gender getGender() {
        return this.gender;
    }

    @Override
    public int compareTo(Person o){
        return gender.compareTo(o.gender) ;
    }
        public String getInfo(){
        return String.format("Пол: %s Полное имя: %s %s %s Дата рождения: %s Дата смерти: %s",gender, surname, firstname, patronymic, birthDate, deathDate);
    }

}