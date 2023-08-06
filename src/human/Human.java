package human;

import java.time.LocalDate;

public class Human {
    private int id;
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private Gender gender;

    public Human(String name, String lastname, LocalDate birthdate, Gender gender) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastname;
    }

    public LocalDate getBirtchdate() {
        return birthdate;
    }

        public Gender gender() {
        return gender;
    }

    @Override
    public String toString() {
        return "id: " + id + 
        ", name: " + name + 
        ", lastname: " + lastname + 
        ", gender: " + gender + 
        ", birhtdate: " + birthdate + " г.р.";
    }
}