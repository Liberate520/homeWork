import java.sql.Date;

public class Human {
    private String firstName;   // Имя
//    private String middleName;  // Отчество
    private String lastName;    // Фамилия
    Gender sex;

    private String fatherName;
    private String motherName;
    private Date birthday;
//    private String birthPlace; // место рождения

    /**Родственник 2+ уровня */
    public Human(String firstName, String lastName, Gender sex, String fatherName, String motherName, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.birthday = birthday;
    }

    /**Родоначальники 1-го уровня дерева */
    public Human(String firstName, String lastName, Gender sex, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Gender getSex() {
        return this.sex;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    @Override
    public String toString() {
        String dt = String.format("%s.%s.%s", this.birthday.getDay(), this.birthday.getMonth(),
                this.birthday.getYear());
        if (this.sex == Gender.Male) {
            return String.format("%s %s, муж., %s", this.firstName, this.lastName, dt);
        } else {
            return String.format("%s %s, жен., %s", this.firstName, this.lastName, dt);
        }
    }
}
