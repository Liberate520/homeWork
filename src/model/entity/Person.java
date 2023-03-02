package model.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person extends BasicEntity {
    private String lastName;
    private LocalDate dateOfDeath;
    private Sex sex;

    // ==================================================================================
    // Constructors

    public Person(String firstName, Sex sex, LocalDate dateOfBirth) {
        this(firstName, null, sex, dateOfBirth);
    }

    public Person(String firstName, Sex sex, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this(firstName, null, sex, dateOfBirth, dateOfDeath);
    }

    public Person(String firstName, String lastName, Sex sex, LocalDate dateOfBirth) {
        this(firstName, lastName, sex, dateOfBirth, null);
    }

    public Person(String firstName, String lastName, Sex sex, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        super(firstName, dateOfBirth);
        this.lastName = lastName;
        this.dateOfDeath = dateOfDeath;
        this.sex = sex;
    }

    // ==================================================================================
    // Getters and Setters

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Sex getSex() {
        return sex;
    }

   
    // ==================================================================================

    public boolean isAlive() {
        if (dateOfDeath == null)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        // Пример: 1 John Doe M 1970.01.01-1990.01.01 children: 2 John, 3 Jane
        StringBuilder strb = new StringBuilder();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        // добавляет id, имя и фамилия
        strb.append(super.getId() + ". ")
            .append(super.getName() + " ");
        if (lastName != null)
            strb.append(lastName + " ");
        // добавляет пол
        if (sex == Sex.MALE)
            strb.append("M    ");
        else
            strb.append("F    ");
        // добавляет дату рождения и смерти
        if (getDateOfBirth() != null) {
            strb.append(getDateOfBirth().format(dateFormat));
            if (dateOfDeath != null)
                strb.append(" - " + dateOfDeath.format(dateFormat));
        }
        return strb.toString();
    }
}
