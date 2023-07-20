package family_tree.person;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.ArrayList;

public class Person {
    static long idc;
    private long id;
    private String firstName;
    private String lastName;
    private Gender genderBirth;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Person mother; // biological mother
    private Person father; // biological father
    private List<Person> spouse; 
// TODO 
/*
    private String givenName;
    private String birthPlace;
    private String deathPlace;
*/



    public Person(String firstName, String lastName, Gender genderBirth, LocalDate birthDate,  
                LocalDate deathDate, Person mother, Person father, Person spouse) {
        this.id = idc++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.genderBirth = genderBirth;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
//        spouse = new ArrayList<>();
    }

    public Person(String firstName, String lastName, Gender genderBirth, LocalDate birthDate){
        this(firstName, lastName, genderBirth, birthDate,null,null,null,null);
    }



    public Person(String firstName, String lastName, Gender genderBirth, LocalDate birthDate, Person mother, Person father){
        this(firstName, lastName, genderBirth, birthDate, null, mother, father, null);
    }

    public long getID(){return id;}

    public String getName() {
        return firstName + " " + lastName;
    }

    public LocalDate getBirthDate(){return birthDate;}

    public String getBirthData(){
        String result = null;

        if (birthDate != null){
            result = birthDate.toString();
        } else {
            result = "unknown date";
        }

//        if (birthPlace != null){ result += "(" + birthPlace + ")"; } // TODO with Places
        return result;
    }

    public LocalDate getDeathDate(){return deathDate;}
    
    public String getDeathData(){
        String result = null;
        if (deathDate != null){
            result = " - " + deathDate;
        }
/* TODO with Places        
        if (deathPlace != null){
            if (result != null){
                result += "(" + deathPlace + ")";
            } else {
                result = " - unknown date (" + deathPlace + ")";
            }
        }
*/        
        return result;
    }

    public String getAlivePeriod(){
        if (getDeathData() != null){
            return getBirthData() + getDeathData();
        } else {
            return getBirthData();
        }
    }

    public String getPerson() {
        return firstName + " " + lastName + ", " + getAlivePeriod();
    }

    private int getAge(){
        if (deathDate == null) {
            return getPeriod(birthDate,LocalDate.now());
        } else {
            return getPeriod(birthDate,deathDate);
        }
    }

    private int getPeriod(LocalDate firstDate, LocalDate secondDate){
        Period diff = Period.between(firstDate,secondDate);
        return diff.getYears();
    }

    
    public Gender getGenderBirth() {return genderBirth;}

    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}
    public void setdeathDate(LocalDate deathDate) {this.deathDate = deathDate;}

    public String getParents(){
        StringBuilder sb = new StringBuilder();
        if (father != null){
            sb.append("father: ");
            sb.append(father);
            sb.append("; ");
        }
        if (mother != null){
            sb.append("mother: ");
            sb.append(mother);
            sb.append("; ");
        }
        return sb.toString();
    }
        
    @Override
    public String toString(){
        return getPersonInfo();
    }

    public String getPersonInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(". ");
        sb.append(getPerson());
        sb.append(" (");
        sb.append(getAge());
        sb.append(" y.o.); ");
        sb.append(getParents());

        return sb.toString();
    }

}
