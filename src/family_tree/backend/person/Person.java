package family_tree.backend.person;

import family_tree.backend.Counts;
import family_tree.backend.ftree.Relatives;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, Relatives<Person> {
    static long idc;
    private long id;
    private String firstName;
    private String lastName;
    private Gender genderBirth;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Person mother; // biological mother
    private Person father; // biological father
    private List<Marriage> marriage = new ArrayList<>();
// TODO: use more fields
/*
    private String maidenName;
    private String birthPlace;
    private String deathPlace;
*/
    public Person(String firstName, String lastName, Gender genderBirth, LocalDate birthDate,
                LocalDate deathDate, Person mother, Person father, List<Marriage> marriage) {

        this.id = idc++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.genderBirth = genderBirth;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        if (marriage == null) {
            this.marriage = new ArrayList<>();
        }
    }
    public Person(String firstName, String lastName, Gender genderBirth, LocalDate birthDate){
        this(firstName, lastName, genderBirth, birthDate,null,null,null,null);
    }

    public Person(String firstName, String lastName, Gender genderBirth, LocalDate birthDate, Person mother, Person father){
        this(firstName, lastName, genderBirth, birthDate, null, mother, father, null);
    }
    public long getID(){return id;}

    public static void setCount(long id){

        idc = id;
    }

    public static void nullCount(){
        setCount(0);
    }

    public String getName() {
        return firstName + " " + lastName;
    }
    public String getLFName() {
        return lastName + " " + firstName;
    }
    public String getBirthData(){
        String result;

        if (birthDate != null){
            result = birthDate.toString();
        } else {
            result = "unknown date";
        }

//        if (birthPlace != null){ result += "(" + birthPlace + ")"; } // TODO with Places
        return result;
    }
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
        return getName() + ", " + getAlivePeriod();
    }

    private int getAge(){
        return getPeriod(birthDate,deathDate);
    }
    public int getPeriod(LocalDate firstDate, LocalDate secondDate){
        if (secondDate == null) {
            secondDate = LocalDate.now();
        }
        Period diff = Period.between(firstDate,secondDate);
        return diff.getYears();
    }

    public Person getMother(){
        return mother;
    }
    public Person getFather(){
        return father;
    }
    public Gender getGender () {return genderBirth;}
    public Gender getGenderBirth() {return genderBirth;}
    public LocalDate getBirthDate(){return birthDate;}
    public LocalDate getDeathDate(){return deathDate;}
    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}
    public void setdeathDate(LocalDate deathDate) {this.deathDate = deathDate;}

    public void setMarriage(List<Person> spouses,String newName,LocalDate inEvent){
        setMarriage(spouses,newName,inEvent,null);
    }
    public void setMarriage(List<Person> spouses, String newName, LocalDate inEvent, LocalDate outEvent){
        Marriage event = new Marriage(spouses, newName, inEvent, outEvent);
        this.marriage.add(event);
    }

    public String getParents(){
        StringBuilder sb = new StringBuilder();
        if (father != null || mother != null) {
            sb.append("\n => [");
            if (father != null) {
                sb.append("father: ");
                sb.append(father);
            }
            if (mother != null) {
                sb.append("mother: ");
                sb.append(mother);
            }
            sb.append("] ");
        }
        return sb.toString();
    }

    public void setFather(Person father){
        this.father = father;
    }

    public void setMother(Person mother){
        this.mother = mother;
    }


    @Override
    public String toString(){
        return getPersonInfo();
    }
    public String getPersonInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(getPerson());
        sb.append(" (");
        sb.append(getAge());
        sb.append(" y.o.) ");
        sb.append(getParents());
        sb.append("; ");
        sb.append(getMarriageInfo());
        return sb.toString();
    }
    public String getMarriageInfo(){
        StringBuilder sB = new StringBuilder();
        sB.append(getSpousesFullList());
        return sB.toString();
    }
    public String getSpousesFullList(){
        StringBuilder sB = new StringBuilder();
        for (Marriage marriageList: marriage){
            Marriage spousesList = marriageList;
            if (spousesList != null) {
                sB.append("\n     *marriage*: ");
                sB.append(marriageList.getMarriageDates());
                sB.append("\n     *spouses*: ");
                for (Person spouse: spousesList.getSpousesList()) {
                    sB.append(spouse.getPerson());
                }
                sB.append("\n");
            }
        }
        return sB.toString();
    }

}
