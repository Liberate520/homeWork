package familly_api.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Human implements Serializable{
    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate born;
    private LocalDate death;
    private Gender gender;

    public Human(String firstName, String lastName, String middleName, LocalDate born, LocalDate death, String gender) {
        if (gender == "male" || gender == "Male") {
            this.gender = Gender.male;
        } else if (gender == "female" || gender == "Female") {
            this.gender = Gender.female; 
        }
        id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.born = born;
        this.death = death;
    }

    public Human(String firstName, LocalDate born, String gender) {
        this(firstName, "нет", "нет", born, null, gender);
    }

    public String getFirstName() {
        return firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Gender getGender() {
        return this.gender;
    }

    public int age() {
        if (this.death == null) {
            return Period.between(this.born, LocalDate.now()).getYears();
        }
        return Period.between(this.born, this.death).getYears();
    }

    public String printHuman() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: " + firstName);
        sb.append("фамилия: " + lastName);
        sb.append("отчество: " + middleName);
        sb.append("возраст: " + this.age());
        sb.append("пол: " + gender);
        return sb.toString();  
    }
}
