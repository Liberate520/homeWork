package member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FamilyMember {
    private String name;
    private String surname;
    private String patronymicName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private FamilyMember mother;
    private FamilyMember father;

    public FamilyMember(String name, String surname, String patronymicName, Gender gender, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.patronymicName = patronymicName;
        this.gender = gender;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.mother = null;
        this.father = null;
    }

    public FamilyMember(String name, String surname, String patronymicName, Gender gender,
                        String birthDate, String deathDate){
        this(name, surname, patronymicName, gender, birthDate);
        this.deathDate = LocalDate.parse(deathDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public void setMother(FamilyMember mother){
        this.mother = mother;
    }

    public FamilyMember getMother(){
        return mother;
    }

    public void setFather(FamilyMember father){
        this.father = father;
    }

    public FamilyMember getFather(){
        return father;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append(surname)
                .append(" ")
                .append(name)
                .append(" ")
                .append(patronymicName)
                .append(", ")
                .append(gender)
                .append(", life years: ")
                .append(birthDate);

        if(deathDate != null){
            sb.append(" - ").append(deathDate);
        } else {
            sb.append(" - ").append("current");
        }
        return sb.toString();
    }

//    private String getFullName(){
//        return surname + " " + name + " " + patronymicName;
//    }
}