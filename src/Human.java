package Tree.homeWork.src;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;

public class Human implements Serializable {
    private String name;
    private int age;
    private int dateOfDeath;
    private int dateOfBirth;
    private Gender gender;
    private TypeCommunication typeCommunication;
    private Human mother;
    private Human father;
    //private List<Human> children;
    public Human(String name, int age, int DateOfBirth, int DateOfDeath, Gender gender, TypeCommunication typeCommunication){
        this.name = name;
        this.age = age;
        this.dateOfBirth = DateOfBirth;
        this.dateOfDeath = DateOfDeath;
        this.gender = gender;
        this.typeCommunication = typeCommunication;
    }
    public String getName() {
        return name;
    }
    public int age() {
        return age;
    }
    public int DateOfBirth() {
        return dateOfBirth;
    }
    public int DateOfDeath() {
        return dateOfDeath;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Gender getGender() {
        return gender;
    }
    public TypeCommunication typeCommunication() {
        return typeCommunication;
    }
    public Human(Human mother) {
        this.mother = mother;
    }
    @Override
    public String toString() {
        return name + ". Age - " +  age + ", " + gender + " " + typeCommunication;
    }
    int index;

    @Override
    public boolean hasNext() {
        return index++ <1;
    }
    @Override
    public String next() {
        switch (index) {
            case 1:
                return String.format(name);
//            case 2:
//                return String.format(age);
//            case 3:
//                return String.format(Gender);
//            case 4:
//                return String.format(dateOfBirth);
//            case 5:
//                return String.format(dateOfDeath);
//            case 6:
//                return String.format(typeCommunication);
        }
    }
}
