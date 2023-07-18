package family_tree.person;

import java.util.Date;

public class Person {
//    private Integer idc;
//    private Integer id;
    private String firstName;
    private String lastName;
    private String givenName;
//    private enum genderBirth {Male,Female};
    private String birthPlace;
//    private Date birthDate;
//    private Date deathDate;
//    private String deathPlace;
//    private Person mother;
//    private Person father;

//    genderBirth genderBirth;

    public Person(String firstName, String lastName, String givenName, String birthPlace){
        this.firstName = firstName;
        this.lastName = lastName;
        this.givenName = givenName;
        this.birthPlace = birthPlace;
    }
/*

    public Person(String firstName, String lastName, String givenName, String birthPlace, Date birthDate, Date deathDate, String deathPlace, Person mother, Person father){
//        this.id = idc++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.givenName = givenName;
//        this.genderBirth = genderBirth;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.deathPlace = deathPlace;
        this.mother = mother;
        this.father = father;
    }
    public Person(String firstName, String lastName, String givenName, genderBirth genderBirth, String birthPlace, Date birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.givenName = givenName;
        this.genderBirth = genderBirth;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
    }
*/

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(){
        //this(firstName:null,lastName:null,givenName:null);
    }

    public String getName() {
        return lastName + " " + firstName;
    }
/*
    public String getBirthData(){
        String result = null;
        if (birthDate != null){
            result = birthDate.toString();
        } else {
            result = "unknown date";
        }

        if (birthDate != null){
            result += "(" + birthPlace + ")";
        }
        return result;
    }

    public String getDeathData(){
        String result = null;
        if (deathDate != null){
            result = " - " + deathDate;
        }
        if (deathPlace != null){
            if (result != null){
                result += "(" + deathPlace + ")";
            } else {
                result = " - unknown date (" + deathPlace + ")";
            }
        }
        
        return result;
    }

    public String getPerson() {
        return lastName + "+" + givenName + "+" + firstName + "+" + birthDate + "+" + birthPlace;
    }

    @Override
    public String toString(){
        return "name:" + firstName + " (" + givenName + ")" + " " + lastName + "\n" + getBirthData() + getDeathData();
    }

    */
    @Override
    public String toString(){
        return "name:" + firstName + " (" + givenName + ")" + " " + lastName + ", " + birthPlace + "\n";
    }

}
