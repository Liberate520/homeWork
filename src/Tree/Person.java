package Tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Person implements Serializable {
    private String name;
    private LocalDate birthDate;
    private Person parent1, parent2;
    private ArrayList<Person> children  = new ArrayList<Person>();

    private Gender gender;

    public Person(String name, Gender gender, String date) {
        this.name = name;
        this.gender = gender;
        this.birthDate = LocalDate.parse(date);
    }
    public LocalDate getBirthDate(){
        return this.birthDate;
    }
    public void setParent1(Person parent1){
        this.parent1 = parent1;
    }

    public void setParent2(Person parent2){
        this.parent2 = parent2;
    }

    void addChild(Person child){
        this.children.add(child);
    }

    public ArrayList<Person> getChildren(){
        return children;
    }

    @Override
    public String toString() {
        String tmp = "name: " + name + "\n"+
                "gender: " + gender + "\n"+
                "date of birth: " + birthDate + "\n" + "parents: ";

        if (this.parent1 != null){
            tmp += parent1.name + ", ";
        }else{
            tmp += "--" + ", ";
        }

        if (this.parent2 != null){
            tmp += parent2.name + "\n";
        }else{
            tmp += "--" + "\n";
        }

        tmp += "children: ";

        for (Person item : children) {
            tmp += item.name + " ";
        }
        tmp += "\n";
        return tmp;

    }
}
