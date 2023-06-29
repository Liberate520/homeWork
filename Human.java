package homeWork_OOP_family_tree;

import java.time.LocalDate;
import java.time.Period;

public class Human {
private String firstName;
private String lastName;
private String middleName;
private LocalDate born;
private LocalDate death;
private String gender;

    

public Human(String firstName, String lastName, String middleName, LocalDate born, LocalDate death, String gender) {
        if (gender == "male" || gender == "Male") {
            this.gender = "male";
        } else if (gender == "female" || gender == "Female") {
            this.gender = "female";
        } else {
            this.gender = "male";
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.born = born;
        this.death = death;
    }



// public Human(String firstName, String lastName, String middleName, LocalDate born, String gender) {
//         this(firstName, lastName, middleName, born, born, gender);
//     }

    public String getGender() {
        return this.gender;
    }

    private Period age(){
        if (this.death == null){
            return Period.between(this.born, LocalDate.now());
        }
        return Period.between(this.born, this.death);
    }

    public void printHuman(){
        System.out.println("имя: " + firstName);
        System.out.println("фамилия: " + lastName);
        System.out.println("отчество: " + middleName);
        System.out.println("возраст: " + this.age());
        System.out.println("пол: " + gender);
    }
}
