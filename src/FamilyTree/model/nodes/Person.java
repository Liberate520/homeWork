package FamilyTree.model.nodes;

// import java.util.ArrayList;
// import java.util.List;
import java.lang.StringBuilder;

public class Person extends Node{
    private String secondName;
    private String surname;

    public Person (String name, String secondName,String surname, Gender gender,int yearOfBirth,int yearOfDeath, Person father,Person mother) {
        super(name, gender, yearOfBirth, yearOfDeath, father, mother);
        this.secondName = secondName;
        this.surname = surname;     
    }
    public Person (String name, String secondName,String surname, Gender gender,int yearOfBirth, int yearOfDeath) {
        this(name, secondName, surname, gender, yearOfBirth, yearOfDeath, null, null);
    }
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int yearOfDeath = getYearOfDeath();
        sb.append("ФИО: ")
            .append(surname)
            .append(" ")
            .append(getName())
            .append(" ")
            .append(secondName)
            .append(", пол: ");
        if(getGender().equals(Gender.m)){
            sb.append("муж. ");
        } else sb.append("жен. ");
        sb.append(getYearOfBirth())
            .append(" - ");
        if(yearOfDeath > 0){
            sb.append(yearOfDeath);
        }
        return sb.toString();
    }

    @Override
    public boolean search(String text) {//поиска по текстовым полям человека, возвращает истину, если текст содержится
        if(super.getName().contains(text) || surname.contains(text) || secondName.contains(text))
            return true;
        return false;    
    }

    @Override
    public String getShortInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(surname).append(";").append(super.getName()).append(";").append(secondName);
        return sb.toString();
    }

}
