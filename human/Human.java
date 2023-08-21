package human;

import tree.Node;

import java.time.LocalDate;

public class Human {
    private String fullName;
    private human.Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;




    public Human(String fullName, human.Gender gender, LocalDate birthDate) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;

    }





    public String getFullName() {
        return fullName;

    }
    public human.Gender getGender() {
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


    public Object addHuman() {
        StringBuilder builder = new StringBuilder();
        builder.append(" имя: ");
        builder.append(getFullName());
        builder.append(", пол: ");
        builder.append(getGender());
        builder.append(", дата рождения: ");
        builder.append(getBirthDate());
        return builder.toString();
    }
}

