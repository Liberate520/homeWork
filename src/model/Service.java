package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Service {
    private FamilyTree tree;
    private TreeSerializer serializer;

    public Service(){
        tree = new FamilyTree();
        addHuman("Анна", "Иванова", LocalDate.of(1970, 1, 1), Gender.FEMALE);
        addHuman("Петр", "Иванов", LocalDate.of(1969, 5, 20), Gender.MALE);
    }

    public void addHuman(String firstName, String lastName, LocalDate birthDate, Gender gender){
        tree.addHuman(new Human(firstName, lastName, birthDate, gender));
    }

    public String getInfo(){
        return tree.toString();
    }



}
