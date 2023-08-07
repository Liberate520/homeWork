package human;

import java.time.LocalDate;

public class Human {
    private String fullName;
    private Gender gender;
    private LocalDate birthDate;
    private Relative relative;

    public Relative getRelative() {
        return relative;
    }

    public String getFullName() {
        return fullName;

    }
    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(" имя: ");
        sb.append(getFullName());
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", дата рождения: ");
        sb.append(getBirthDate());
        sb.append(" если он(а) является ");
        return sb.toString();
    }

    public Human(String fullName, Gender gender, LocalDate birthDate) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;


    }

}

